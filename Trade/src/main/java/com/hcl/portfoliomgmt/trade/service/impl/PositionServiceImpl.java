package com.hcl.portfoliomgmt.trade.service.impl;

import com.hcl.portfoliomgmt.trade.repository.PositionRepository;
import com.hcl.portfoliomgmt.trade.service.PositionService;
import com.hcl.portfoliomgmt.trade.entity.Position;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    @Override
    public List<Position> getCurrentPositions(String customerId) {
        log.info("Get Current Positions for the customer. Customer ID: {}", customerId);
        return this.positionRepository.findByCustomerId(customerId);
    }
}
