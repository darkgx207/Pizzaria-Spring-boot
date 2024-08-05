package com.example.pizza_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizza_app.dto.CreatePizzaDto;
import com.example.pizza_app.model.Pizza;
import com.example.pizza_app.service.PizzaService;


@RestController
@RequestMapping("pizza")
public class PizzaController {

  @Autowired
  private PizzaService pizzaService;
  

  @PostMapping
  public ResponseEntity<?> createPizza(@RequestBody CreatePizzaDto pizzaDto) throws Exception {
    Pizza pizza = pizzaService.createPizza(pizzaDto);
    return ResponseEntity.status(201).body(pizza);
  }

  // @GetMapping
  // public ResponseEntity<Pizza[]> getAllFlavours() {
  //   return null;
  // }

  @GetMapping
  public ResponseEntity<?> findAllFlavorsByIds(@RequestParam("flavours") List<Long> flavors) throws Exception {
    System.out.println(flavors);
    List<Pizza> pizzas = pizzaService.findAllFlavorsByIds(flavors);
    return ResponseEntity.status(200).body(pizzas);
  }
}
