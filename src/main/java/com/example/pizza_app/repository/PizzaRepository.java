package com.example.pizza_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pizza_app.model.Pizza;



public interface PizzaRepository extends JpaRepository<Pizza, Long> {
  
}
