package com.au.Kafka.service;

import org.springframework.stereotype.Service;

import com.au.Kafka.model.Order;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@Service
public class ProducerService {
	
	@Autowired
    private KafkaTemplate<String, String> kt;

    public void createOrder(Order order) {
        String topicName = "placeorder";
        kt.send(topicName, order.toString());
        log.info("Kafka Order Produced(Created) by Producer, msg = {}", order.toString());
    }

    public void shipOrder(Order order) {
        String topicName = "deliverorder";
        kt.send(topicName, order.toString());
        log.info("#Kafka Order Shipped by Producer , msg = {}", order.toString());
    }

}
