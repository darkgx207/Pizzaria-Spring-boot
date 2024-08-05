package com.example.pizza_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pizza_app.dto.CreateOrderDto;
import com.example.pizza_app.enums.PizzaStatus;
import com.example.pizza_app.model.Order;
import com.example.pizza_app.repository.OrderRepository;
import com.example.pizza_app.repository.PizzaRepository;

@Service
public class OrderService {
  
  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private PizzaRepository pizzaRepository;


  public Order CreateOrder(CreateOrderDto orderDto) { 
      Order order = new Order();
      order.setPizzas(pizzaRepository.findAllById(orderDto.pizzas()));
      order.setClientName(orderDto.clientName());
      order.setStatus(PizzaStatus.WAITING);
      order.setPaid(orderDto.paid());

      System.out.println(order);

      return orderRepository.save(order);
  }

}
