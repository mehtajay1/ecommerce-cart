package com.team2.cart.repository;

import com.team2.cart.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
//
//    @Query("UPDATE cart SET quantity = quantity + 1")
//    void updateQuantity();

    Cart findByCustomerId(String customerId);
    Cart findByCustomerEmailId(String emailId);

}
