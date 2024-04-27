package com.hcl.portfoliomgmt.trade.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="position_id")
    private String positionId;

    @Column(name="transaction_ref")
    private String transactionRef;

    @Column(name="portfolio_id")
    private Long portfolioId;

    @Column(name="instrument_id")
    private Long instrumentId;

    @Column(name="customer_id")
    private String customerId;

    @Column(name="position_value")
    private Long positionValue;

}
