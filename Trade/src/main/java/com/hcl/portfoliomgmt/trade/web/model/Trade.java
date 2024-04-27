package com.hcl.portfoliomgmt.trade.web.model;

import com.hcl.portfoliomgmt.trade.constants.TradeType;
import lombok.Data;

@Data
public class Trade {
    private String instrument;
    private long quantity;
    private TradeType tradeType;
}
