package com.example.pizza_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pizza_app.dto.CreatePizzaDto;
import com.example.pizza_app.model.Pizza;
import com.example.pizza_app.repository.PizzaRepository;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public Pizza createPizza(CreatePizzaDto pizzaDto) throws Exception {
        try {
            Pizza pizza = new Pizza();
            pizza.setFlavor(pizzaDto.flavor());
            pizza.setPrice(pizzaDto.price());
            return pizzaRepository.save(pizza);

        } catch (Exception e) { throw new Exception(); }
    }


    public List<Pizza> findAllFlavorsByIds(List<Long> ids) throws Exception {
      try {
        List<Pizza> pizzas = pizzaRepository.findAllById(ids);
        return pizzas;

      } catch (Exception e) { throw new Exception(); }
    }
}
