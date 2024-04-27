package com.ude.hackathon.hcl.model;

import com.ude.hackathon.hcl.constant.InstrumentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "instrument")
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "instrument_name")
    private String instrumentName;

    @Column(name = "instrument_value")
    private double instrumentValue;

    @Column(name = "instrument_type")
    private InstrumentType instrumentType;

//    @Column(name = "create_date")
//    private Date createdDate;
//
//    @Column(name = "updated_date")
//    private Date updatedDate;
}


