package com.ndbk.uber;

import java.util.HashMap;
import java.util.Map;

import com.ndbk.uber.model.Trade;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import reactor.kafka.receiver.internals.ConsumerFactory;

@SpringBootApplication
@EnableKafka
public class UberApplication {
	public static void main(String[] args) {
		SpringApplication.run(UberApplication.class, args);
	}
}
