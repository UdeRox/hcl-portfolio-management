package com.ude.hackathon.hcl.controller;

import com.ude.hackathon.hcl.model.Portfolio;
import com.ude.hackathon.hcl.service.PortfolioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PortFolioController {

    @Autowired
    PortfolioService portfolioService;

    @GetMapping("portfolio")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Portfolio> getById(@RequestHeader("email") String email) {
        log.info("Fetching Portfolio for current user. CustomerID: {}", email);
        return ResponseEntity.status(HttpStatus.OK).body(portfolioService.getByEmail(email));
    }
}
