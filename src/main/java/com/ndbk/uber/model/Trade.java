package com.ndbk.uber.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Trade {
    @JsonProperty("e")
    public String eventType;
    @JsonProperty("E")
    public long eventTime;
    @JsonProperty("s")
    public String symbol;
    @JsonProperty("a")
    public String aggregateTradeId;
    @JsonProperty("p")
    public double price;
    @JsonProperty("q")
    public double quantity;
    @JsonProperty("f")
    public String firstTradeId;
    @JsonProperty("l")
    public String lastTradeId;
    @JsonProperty("T")
    public String tradeTime;
    @JsonProperty("m")
    public boolean isMarketMatcher;
    @JsonProperty("M")
    public boolean ignore;
}

