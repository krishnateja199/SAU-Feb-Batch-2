package com.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        System.out.println("Starting Kafka Order System Application on port 8000");
        SpringApplication.run(KafkaApplication.class, args);
        System.out.println("Started Kafka Order System Application on port 8000\n");
    }

}