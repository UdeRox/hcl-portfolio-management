package com.ude.hackathon.hcl.model;

import com.ude.hackathon.hcl.constant.InvestmentStrategyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="portfolio")

public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="customer_id")
    private String customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name="portfolio_number")
    private String portfolioNumber;

    @Column(name="portfolio_value")
    private Double portfolioValue;

    @Column(name="current_performance")
    private Double currentPerformance;

    @Column(name="investment_strategy")
    private InvestmentStrategyType investmentStrategy;
}
