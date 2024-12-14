package com.ndbk.uber.service;

import java.util.ArrayList;
import java.util.List;

import com.ndbk.uber.model.Trade;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Service
public class TradeConsumerService {
    private final List<FluxSink<String>> sinks = new ArrayList<>();
    public Flux<String> consume() {
        return Flux.create(sinks::add);
    }

    @KafkaListener(topics = "binance-trades", groupId = "binance-trade-group")
    public void listen(String trade) {
        for (FluxSink<String> sink : sinks) {
            sink.next(trade);
        }
    }
}
