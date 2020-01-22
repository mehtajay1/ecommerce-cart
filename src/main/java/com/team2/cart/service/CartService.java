package com.team2.cart.service;

import com.team2.cart.entity.Cart;
import com.team2.cart.entity.Product;

import java.util.List;

public interface CartService {
    Cart getCart(String custId);
    Cart addToCart(Product product,String custId);
}
