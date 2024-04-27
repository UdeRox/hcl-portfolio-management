package com.hcl.portfoliomgmt.trade.repository;

import com.hcl.portfoliomgmt.trade.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    List<Position> findByCustomerId(String customerId);
}
