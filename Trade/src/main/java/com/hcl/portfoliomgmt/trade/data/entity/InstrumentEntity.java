package com.hcl.portfoliomgmt.trade.data.entity;

import com.hcl.portfoliomgmt.trade.constants.InstrumentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Instrument")
@Data
public class InstrumentEntity {
    @Id
    private Long instrumentId;

    @Column(name="instrument_name")
    private String instrumentName;

    @Column(name="instrument_value")
    private double instrumentValue;

    @Column(name="instrument_type")
    private InstrumentType instrumentType;

    @Column(name="create_date")
    private Date createdDate;

    @Column(name="updated_date")
    private Date updatedDate;
}
