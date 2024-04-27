package com.ude.hackathon.hcl.service;

import com.ude.hackathon.hcl.model.Portfolio;
import com.ude.hackathon.hcl.repo.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class PortfolioService {
    @Autowired
    PortfolioRepository portfolioRepository;

    public Portfolio getById(Long portfolioId) {
        Optional<Portfolio> byId = portfolioRepository.findById(portfolioId);
        return byId.isEmpty()? null: byId.get();
    }

    public Portfolio getByEmail(String email){
        Optional<Portfolio> byId = portfolioRepository.findByCustomerId(email);
        return byId.isEmpty()? null: byId.get();
    }

}
