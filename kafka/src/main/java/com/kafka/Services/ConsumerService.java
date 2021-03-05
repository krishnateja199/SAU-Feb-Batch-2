package com.kafka.Services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ConsumerService {

    @KafkaListener(topics = "create-order")
    public void consumeCreatedOrder(String order) {
        log.info("##################  Consumer Consumed Created Order = {}", order);
    }

    @KafkaListener(topics = "ship-order")
    public void consumeShippedOrder(String order) {
        log.info("##################  Consumer Consumed Shipped Order = {}", order);
    }
}