package com.example.pizza_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizza_app.dto.CreateOrderDto;
import com.example.pizza_app.model.Order;
import com.example.pizza_app.service.OrderService;


@RestController
@RequestMapping("order")
public class OrderController {
  
  @Autowired
  private OrderService orderService;


  @PostMapping
  public ResponseEntity<?> createOrder(@RequestBody CreateOrderDto orderDto) {
    Order order = orderService.CreateOrder(orderDto);
    return ResponseEntity.status(201).body(order);
  }
}
