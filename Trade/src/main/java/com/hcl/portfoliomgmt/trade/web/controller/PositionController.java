package com.hcl.portfoliomgmt.trade.web.controller;

import com.hcl.portfoliomgmt.trade.data.entity.Position;
import com.hcl.portfoliomgmt.trade.service.PositionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
@Slf4j
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Position>> fetchCurrentPosition(@RequestHeader(value="customer-id") String customerId){
        log.info("Fetching Current Position of user. CustomerID: {}", customerId);
        return ResponseEntity.status(HttpStatus.OK).body(this.positionService.getCurrentPositions(customerId));
    }}
