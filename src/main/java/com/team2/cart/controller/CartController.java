package com.team2.cart.controller;

import com.team2.cart.DTO.CartDTO;
import com.team2.cart.DTO.ProductDTO;
import com.team2.cart.entity.Cart;
import com.team2.cart.entity.Product;
import com.team2.cart.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/get/cart/{custId}")
    public Cart getCart(@PathVariable("custId") String id){
        return cartService.getCart(id);
    }

    @PostMapping("/add/cart/{custId}")
    public ResponseEntity<Cart> addToCart(@PathVariable("custId") String custId, @RequestBody ProductDTO productDTO){
        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);
        Cart cartCreated = cartService.addToCart(product,custId);
        return new ResponseEntity<>(cartCreated,HttpStatus.CREATED);
    }





}
