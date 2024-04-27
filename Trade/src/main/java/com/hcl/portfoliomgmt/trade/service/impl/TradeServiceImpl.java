package com.hcl.portfoliomgmt.trade.service.impl;

import com.hcl.portfoliomgmt.trade.constants.TradeType;
import com.hcl.portfoliomgmt.trade.entity.Instrument;
import com.hcl.portfoliomgmt.trade.entity.Position;
import com.hcl.portfoliomgmt.trade.kafka.AuditProducer;
import com.hcl.portfoliomgmt.trade.repository.InstrumentRepository;
import com.hcl.portfoliomgmt.trade.repository.PositionRepository;
import com.hcl.portfoliomgmt.trade.service.TradeService;
import com.hcl.portfoliomgmt.trade.web.model.Trade;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class TradeServiceImpl implements TradeService {

    private final PositionRepository positionRepository;
    private final InstrumentRepository instrumentRepository;
    private final AuditProducer auditProducer;
    @Value("${spring.kafka.topic}")
    private String topic;

    public TradeServiceImpl(PositionRepository positionRepository, InstrumentRepository instrumentRepository, AuditProducer auditProducer) {
        this.positionRepository = positionRepository;
        this.instrumentRepository = instrumentRepository;
        this.auditProducer = auditProducer;
    }

    @Override
    public void addTrade(Trade trade, String customerId) throws Exception {

        //update position for the customer
        List<Position> positions = positionRepository.findByCustomerId(customerId);
        List<Instrument> instruments = instrumentRepository.findByInstrumentName(trade.getInstrument());

        if (instruments.isEmpty()) {
            throw new Exception("Instrument not found");
        }

        String tradeJson = """
                {
                    "customerId": "%s",
                    "instrument": "%s",
                    "quantity": %d,
                    "tradeType": "%s"
                }
                """.formatted(customerId, trade.getInstrument(), trade.getQuantity(), trade.getTradeType());

        auditProducer.sendAuditMessage(topic, tradeJson);

        if (positions.isEmpty() && trade.getTradeType().equals(TradeType.BUY)) {
            Position position = new Position();
            position.setCustomerId(customerId);
            position.setInstrumentId(instruments.get(0).getInstrumentId());
            position.setPortfolioId(1L);
            position.setPositionValue(trade.getQuantity());
            positionRepository.save(position);
        } else {
            Position position = positions.get(0);
            if (trade.getTradeType().equals(TradeType.SELL) && position.getPositionValue() < trade.getQuantity()) {
                throw new Exception("Insufficient quantity");
            }

            //if selling
            if (trade.getTradeType().equals(TradeType.SELL)) {
                position.setPositionValue(position.getPositionValue() - trade.getQuantity());
                positionRepository.save(position);
                return;
            }

            position.setPositionValue(position.getPositionValue() + trade.getQuantity());
            positionRepository.save(position);
        }


    }
}
