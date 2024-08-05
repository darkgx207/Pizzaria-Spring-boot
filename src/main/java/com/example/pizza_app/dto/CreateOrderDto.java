package com.example.pizza_app.dto;

import java.util.List;

public record CreateOrderDto(String clientName, List<Long> pizzas, boolean paid ) {

}
