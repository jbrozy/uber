package com.ndbk.uber.controller;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import com.ndbk.uber.service.AggregatedTradeConsumerService;
import com.ndbk.uber.service.TradeConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/binance")
public class BinanceController {
    @Autowired
    private TradeConsumerService tradeConsumerService;

    @Autowired
    private AggregatedTradeConsumerService aggregatedTradeConsumerService;

    public BinanceController() {
    }

    @CrossOrigin
    @GetMapping(value = "/trades", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getTrades(){
        return tradeConsumerService.consume();
    }

    @CrossOrigin
    @GetMapping(value = "/trades/aggregated", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getTradesAggregated(){
        return aggregatedTradeConsumerService.consume();
    }
}
