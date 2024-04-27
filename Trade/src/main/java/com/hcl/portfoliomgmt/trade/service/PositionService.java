package com.hcl.portfoliomgmt.trade.service;

import com.hcl.portfoliomgmt.trade.web.model.Position;

import java.util.List;

public interface PositionService {

    List<Position> getCurrentPostions(String email);

}
