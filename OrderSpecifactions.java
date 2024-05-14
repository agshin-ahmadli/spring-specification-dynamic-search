package com.example.springtrialruning.spec;

import com.example.springtrialruning.model.Order;
import com.example.springtrialruning.model.OrderStatus;
import com.example.springtrialruning.model.Product;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import javax.lang.model.type.PrimitiveType;

public class OrderSpecifactions {

    public static Specification<Order> hasCustomerName(String name){

        // select o from order o join customer c on o.customer_id=c.id where c.name=name
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("customer").get("name"),name);
    }

    public static Specification<Order> hasStatus(OrderStatus status){
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("status"),status);
    }

    public static Specification<Order> hasProductCategory(String category){
        return (root, query, criteriaBuilder) -> {
            Join<Order, Product>productJoin = root.join("products", JoinType.INNER);
            return criteriaBuilder.equal(productJoin.get("category"),category);
        };
    }

    public static Specification<Order>hasProductPriceGreaterThan(double price){
        return (root, query, criteriaBuilder) -> {
            Join<Order, Product>productJoin = root.join("products",JoinType.INNER);
            return criteriaBuilder.greaterThan(productJoin.get("price"),price);
        };
    }
}
