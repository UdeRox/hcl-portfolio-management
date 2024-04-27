package com.ude.hackathon.hcl.repo;

import com.ude.hackathon.hcl.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio,Long> {
    Optional<Portfolio> findByCustomerId(String customerID);
}
