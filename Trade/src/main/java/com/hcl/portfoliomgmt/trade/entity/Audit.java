package com.hcl.portfoliomgmt.trade.entity;


import com.hcl.portfoliomgmt.trade.constants.TradeType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Audit")
@Data
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    @Column(name="transaction_ref")
    private String transactionRef;

    @Column(name="instrument_id")
    private Long instrumentId;

    @Column(name="trade_type")
    private TradeType tradeType;
}
