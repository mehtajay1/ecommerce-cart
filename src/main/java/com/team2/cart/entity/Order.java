package com.team2.cart.entity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "order")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {


    @Id
    private String id;

    //    @JsonBackReference
    private List<Product> productsBought;

    private String dateOfPlacingOrder;
    private String customerId;
    private String Address;
}