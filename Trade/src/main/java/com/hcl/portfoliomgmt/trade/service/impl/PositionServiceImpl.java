package com.hcl.portfoliomgmt.trade.service.impl;

import com.hcl.portfoliomgmt.trade.service.PositionService;
import com.hcl.portfoliomgmt.trade.web.model.Position;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PositionServiceImpl implements PositionService {

    @Override
    public List<Position> getCurrentPostions(String email) {
        return List.of();
    }
}
