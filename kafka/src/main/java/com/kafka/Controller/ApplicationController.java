package com.kafka.Controller;

import com.kafka.Models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kafka.Services.ProducerService;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@RestController
@CrossOrigin("*")
@Slf4j
public class ApplicationController {

    @Autowired
    private ProducerService producerService;

    private HashMap<Integer, Order> orders = new HashMap<>();
    private int lastGivenOrderId = 0;

    @PostMapping(value = "/create-order")
    public ResponseEntity<Order> produceNewOrder(@RequestBody Order order) {
        log.debug("Inside controller");
        order.setOrderId(++lastGivenOrderId);
        System.out.println(order.toString());
        producerService.createOrder(order);
        orders.put(lastGivenOrderId, order);
        return new ResponseEntity(order, HttpStatus.CREATED);
    }

    @GetMapping(value = "/ship-order/{orderId}")
    public ResponseEntity<Order> produceNewShippingOrder(@PathVariable(required = true, name = "orderId") int orderId) {
        log.debug("Inside controller");
        if(orders.containsKey(orderId)) {
            producerService.shipOrder(orders.get(orderId));
            Order tempOrder = orders.get(orderId);
            orders.remove(orderId);
            return new ResponseEntity(tempOrder, HttpStatus.OK);
        }
        else{
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

}