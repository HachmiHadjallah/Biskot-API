package com.biskot.domain.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.biskot.domain.model.Cart;

@Service
public interface CartService {

    void createCart(Cart cart);

    Cart getCart(int cartId);

    void addItemToCart(int cartId, int product_id, int quantity);
    
    List<Cart> getAllCarts();
    void putItemToCart(int cartId, int product_id, int quantity);
    
  
    
}
