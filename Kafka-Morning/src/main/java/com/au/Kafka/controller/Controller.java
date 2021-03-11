package com.au.Kafka.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.Kafka.model.Order;
import com.au.Kafka.service.ProducerService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("*")
@Slf4j
public class Controller {
	
	@Autowired
    private ProducerService producerService;

    private List<Order> orders = new ArrayList<>();

    @PostMapping(value = "/placeorder")
    public ResponseEntity<Order> produceNewOrder(@RequestBody Order order) {
        System.out.println(order.toString());
        producerService.createOrder(order);
        orders.add(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping(value = "/deliver/{orderId}")
    public ResponseEntity<Order> produceNewShippingOrder(@PathVariable(name = "orderId") int orderId) {
        for (int i = 0; i<orders.size(); i++) {
            if (orderId == (orders.get(i)).getOrderId()) {
                producerService.shipOrder(orders.get(i));
                Order temporder = orders.get(i);
                orders.remove(i);
                return new ResponseEntity<>(temporder, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
