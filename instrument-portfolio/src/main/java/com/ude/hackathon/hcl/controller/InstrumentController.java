package com.ude.hackathon.hcl.controller;

import com.ude.hackathon.hcl.instrument.InstrumentRepository;
import com.ude.hackathon.hcl.model.Instrument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class InstrumentController {
    @Autowired
    InstrumentRepository instrumentRepository;

    @GetMapping("instruments")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<Instrument>> getAllInstruments() {
        log.info("Fetching all Instruments");
        return ResponseEntity.status(HttpStatus.OK).body(instrumentRepository.findAll());
    }
}
