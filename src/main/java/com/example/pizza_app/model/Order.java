package com.example.pizza_app.model;

import java.util.List;

import com.example.pizza_app.enums.PizzaStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity(name = "Orders") 
@Data
public class Order {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column
  private Long id;

  @Column
  @NotEmpty
  private String clientName;

  @Column
  @NotNull
  private PizzaStatus status;


  @Column
  @NotEmpty
  private boolean paid;

  @ManyToMany
  @JoinTable(
    name = "OrderPizzas",
    joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "pizza_id")
  )
  private List<Pizza> pizzas;

}
