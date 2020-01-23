package com.team2.cart.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;


@Document(collection="cart")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {
    @Id
    private String customerEmailId;
//    @JsonBackReference
    private List<Product> productsBought;

    private Date dateOfPlacingOrder;
    private String customerId;
    private String address;
}
