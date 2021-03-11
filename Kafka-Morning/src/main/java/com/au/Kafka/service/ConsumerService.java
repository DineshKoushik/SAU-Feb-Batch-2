package com.au.Kafka.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;

@Service
@Slf4j
public class ConsumerService {
	
	@KafkaListener(topics = "placeorder")
    public void consumeCreatedOrder(String order) {
        log.info("Consumer Consumed Placed Order = {}", order);
    }

    @KafkaListener(topics = "deliverorder")
    public void consumeShippedOrder(String order) {
        log.info("Consumer Consumed Delivered Order = {}", order);
    }

}
