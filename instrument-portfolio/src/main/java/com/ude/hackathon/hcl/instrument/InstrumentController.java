package com.ude.hackathon.hcl.instrument;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InstrumentController {
    @Autowired
    InstrumentRepository instrumentRepository;

    @GetMapping("instruments")
    List<Instrument> getById() {
        return instrumentRepository.findAll();
    }
}
