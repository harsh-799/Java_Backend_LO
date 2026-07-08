package com.harsh.microservices.ecom_orderservice.controller;

import com.harsh.microservices.ecom_orderservice.dto.InventoryCheckResponse;
import com.harsh.microservices.ecom_orderservice.dto.OrderResponse;
import com.harsh.microservices.ecom_orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/place/{id}")
    public ResponseEntity<OrderResponse> placeTheOrder(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.placeOrder(id));
    }
}
