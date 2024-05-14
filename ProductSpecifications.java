package com.example.springtrialruning.spec;

import com.example.springtrialruning.model.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifications {

    public static Specification<Product> hasName(String name){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("name"),name);
    }
    public static Specification<Product> hasPriceGreaterThan(double price){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("price"), price);
    }
}
