package com.hcl.portfoliomgmt.trade.service;

import com.hcl.portfoliomgmt.trade.entity.Position;

import java.util.List;

public interface PositionService {

    List<Position> getCurrentPositions(String customerId);

}
