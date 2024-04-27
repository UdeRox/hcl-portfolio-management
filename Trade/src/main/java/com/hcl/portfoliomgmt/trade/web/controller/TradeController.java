package com.hcl.portfoliomgmt.trade.web.controller;

import com.hcl.portfoliomgmt.trade.service.TradeService;
import com.hcl.portfoliomgmt.trade.web.model.Trade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trade")
public class TradeController {

    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Trade trade){
        this.tradeService.addTrade(trade);
    }
}
