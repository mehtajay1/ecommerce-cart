package com.team2.cart.service.impl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.team2.cart.entity.Cart;
import com.team2.cart.entity.Product;
import com.team2.cart.repository.CartRepository;
import com.team2.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;


    @Override
    public Cart getCart(String custId) {
        Cart cartDetails = cartRepository.findByCustomerId(custId);
        return cartDetails;
    }

    @Override
    public Cart addToCart(Product product, String custId) {
//        Cart cartDetails = cartRepository.findByCustomerId(custId);
        Cart existingCart = cartRepository.findByCustomerId(custId);
        if (existingCart != null) {
            List<Product> productDetails = existingCart.getProductsBought();
            List<Product> updatedList = new ArrayList<>();
            //updatedList = existingCart.getProductsBought();
            for (Product product1 : productDetails) {
                if (product1.getProductId().equals(product.getProductId()))
                    product1.setQuantity(product.getQuantity());
                else
                    updatedList.add(product);
            }
            for (Product listval : updatedList) {
                productDetails.add(listval);
            }
            existingCart.setProductsBought(productDetails);
            cartRepository.save(existingCart);
            return existingCart;
        } else {
            Cart cart = new Cart();
            cart.setCustomerId(custId);
            List<Product> newList = new ArrayList<>();
            newList.add(product);
            cart.setProductsBought(newList);
            cart.setAddress("ab");
            cart.setCustomerEmailId("A@123.com");
            cartRepository.save(cart);

            return cart;
        }
    }
}
