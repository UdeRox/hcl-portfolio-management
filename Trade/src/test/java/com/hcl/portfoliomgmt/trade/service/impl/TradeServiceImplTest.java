package com.hcl.portfoliomgmt.trade.service.impl;

import com.hcl.portfoliomgmt.trade.constants.TradeType;
import com.hcl.portfoliomgmt.trade.entity.Instrument;
import com.hcl.portfoliomgmt.trade.entity.Position;
import com.hcl.portfoliomgmt.trade.kafka.AuditProducer;
import com.hcl.portfoliomgmt.trade.repository.InstrumentRepository;
import com.hcl.portfoliomgmt.trade.repository.PositionRepository;
import com.hcl.portfoliomgmt.trade.web.model.Trade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TradeServiceImplTest {

    @InjectMocks
    TradeServiceImpl tradeService;

    @Mock
    PositionRepository positionRepository;

    @Mock
    InstrumentRepository instrumentRepository;

    @Mock
    AuditProducer auditProducer;

    @Mock
    KafkaTemplate<String, String> kafkaTemplate;


    @Test
    void testAddTrade_success() throws Exception {
        List<Instrument> instruments = new ArrayList<>();
        Instrument instrument = new Instrument();
        instrument.setInstrumentName("AAPL");
        instrument.setInstrumentValue(100.0);
        instrument.setInstrumentId(1L);
        instruments.add(instrument);

        List<Position> positions = new ArrayList<>();
        Position position = new Position();
        position.setCustomerId("1");
        position.setInstrumentId(1L);
        position.setPortfolioId(1L);
        position.setPositionValue(10L);
        positions.add(position);

        tradeService.setTopic("topic");

        String tradeJson = """
                {
                    "customerId": "%s",
                    "instrument": "%s",
                    "quantity": %d,
                    "tradeType": "%s"
                }
                """.formatted("1", "AAPL", 10L, TradeType.BUY);

        Mockito.doReturn(instruments).when(instrumentRepository).findByInstrumentName("AAPL");
        Mockito.doReturn(positions).when(positionRepository).findByCustomerId("1");
        CompletableFuture<SendResult<String, String>> future = new CompletableFuture<>();
        when(kafkaTemplate.send(Mockito.anyString(), Mockito.any())).thenReturn(future);
        Mockito.doNothing().when(auditProducer).sendAuditMessage("topic", Mockito.anyString());

        tradeService.addTrade(new Trade("AAPL", 10L, TradeType.BUY), "1");
       // Mockito.verify(positionRepository, Mockito.times(1)).save(Mockito.any());
    }
}