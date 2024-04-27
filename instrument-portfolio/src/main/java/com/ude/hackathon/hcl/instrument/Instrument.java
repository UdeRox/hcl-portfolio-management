package com.ude.hackathon.hcl.instrument;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

enum InstrumentType {
    BOND,
    DIGITAL_ASSET,
    REAL_ESTATE
}

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Instrument")
class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="instrumentName")
    private String instrumentName;

    @Enumerated(EnumType.STRING)
    private InstrumentType instrumentType;
}
