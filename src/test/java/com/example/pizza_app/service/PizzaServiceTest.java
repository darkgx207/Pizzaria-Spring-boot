package com.example.pizza_app.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.pizza_app.model.Pizza;
import com.example.pizza_app.repository.PizzaRepository;

@SpringBootTest 
@ActiveProfiles("test")
// @DataJpaTest
public class PizzaServiceTest {

  @Autowired
  private PizzaRepository pizzaRepository;

  @Test
  void savePizza() { // Should create pizza and return pizza

    Pizza pizza = new Pizza();
    pizza.setFlavor("tradicional");
    pizza.setPrice((float)20);

    Pizza expectedPizza = pizzaRepository.save(pizza);

    Assertions.assertThat(expectedPizza).isNotNull();
  }


  @Test
  void findAllPizzasById() {

    Pizza pizza1 = new Pizza("calabresa", (float) 25);
    Pizza pizza2 = new Pizza("tradiconal", (float) 20);
    Pizza pizza3 = new Pizza("portuguesa", (float) 23);

    pizzaRepository.saveAll(List.of(pizza1,pizza2,pizza3));

    List<Pizza> pizzas = pizzaRepository.findAllById(List.of(1L,3L,4L));

    Assertions.assertThat(pizzas.size()).isEqualTo(2);
  }



}