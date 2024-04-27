package com.hcl.portfoliomgmt.trade.data.entity;


import com.hcl.portfoliomgmt.trade.constants.TradeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Audit")
@Data
public class Audit {

    @Id
    private Long auditId;

    @Column(name="transaction_ref")
    private String transactionRef;

    @Column(name="instrument_id")
    private Long instrumentId;

    @Column(name="trade_type")
    private TradeType tradeType;
}
