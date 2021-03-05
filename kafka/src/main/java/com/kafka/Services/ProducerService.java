package com.kafka.Services;

import com.kafka.Models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, String> createOrShipKafkaTemplate;

    public void createOrder(Order order) {
        String topicName = "create-order";
        createOrShipKafkaTemplate.send(topicName, order.toString());
        log.info("########## Kafka Order Produced(Created) by Producer, msg = {}", order.toString());
    }

    public void shipOrder(Order order) {
        String topicName = "ship-order";
        createOrShipKafkaTemplate.send(topicName, order.toString());
        log.info("########## Kafka Order Shipped by Producer , msg = {}", order.toString());
    }
}