package com.example.pizza_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Pizzas") 
@Data @NoArgsConstructor
public class Pizza {

  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank
  private String flavor;

  @NotNull
  private float price;

  public Pizza(String flavor, float price) {
    this.flavor = flavor;
    this.price = price;
  }

  // @ManyToMany(mappedBy = "pizzas")
  // private List<Orders> order;


  


}
