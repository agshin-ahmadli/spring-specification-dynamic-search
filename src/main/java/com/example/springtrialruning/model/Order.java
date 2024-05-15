package com.example.springtrialruning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_list")
public class Order extends BaseEntity{

    String name;
    String orderStatus;
    String category;
    double price;

    @OneToMany(mappedBy = "order")
    private List<Product>products = new ArrayList<>();
}
