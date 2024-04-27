package com.hcl.portfoliomgmt.trade.web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Position {
/*[{
        "TransactionRef": 0,
                "InstrumentId": 0,
                "InstrumentName": "",
                "InstrumentValue": 0,
                "InstrumentType": ""
    }]*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String positionId;

    private String transactionRef;

    private Long portfolioId;

    private Long instrumentId;

    private String customerId;

}
