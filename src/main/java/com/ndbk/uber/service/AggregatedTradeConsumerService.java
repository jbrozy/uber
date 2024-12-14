package com.ndbk.uber.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Service
public class AggregatedTradeConsumerService {
    private final List<FluxSink<String>> sinks = new ArrayList<>();
    public Flux<String> consume() {
        return Flux.create(sinks::add);
    }

    @KafkaListener(topics = "binance-trades-aggregated", groupId = "binance-trade-group")
    public void listen(String trade) {
        for (FluxSink<String> sink : sinks) {
            sink.next(trade);
        }
    }
}
