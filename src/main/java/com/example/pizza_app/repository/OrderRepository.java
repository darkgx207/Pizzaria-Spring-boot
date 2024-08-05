package com.example.pizza_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pizza_app.model.Order;




public interface OrderRepository extends JpaRepository<Order, Long> {

}
