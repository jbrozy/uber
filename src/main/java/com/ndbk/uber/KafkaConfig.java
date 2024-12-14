package com.ndbk.uber;

import java.util.HashMap;
import java.util.Map;

import com.ndbk.uber.model.Trade;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class KafkaConfig {
    @Bean
    public DefaultKafkaConsumerFactory<String, Object> consumerFactory(){
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "138.201.203.245:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "binance-trades-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*"); // Adjust as needed
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, Trade.class.getName()); // Specify the class name of your Trade object

        return new DefaultKafkaConsumerFactory<String, Object>(props,
            new StringDeserializer(),
            new ErrorHandlingDeserializer<>(new JsonDeserializer(Object.class)));
    }
}
