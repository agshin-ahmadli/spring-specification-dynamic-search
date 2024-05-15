package com.example.springtrialruning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity{
    @NotNull(message = "the item can not be empty")
    String name;
    @NotBlank(message = "price must be set")
    Double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
