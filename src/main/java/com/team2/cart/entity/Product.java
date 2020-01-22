package com.team2.cart.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
public class Product {

    private String productId;
    private String name;
    private Double price;
    private String image;
    private int quantity;
    private String merchantId;
    private String merchantName;
//
//    @ToString.Exclude
//    private Cart cart;
}
