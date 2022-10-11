package com.biskot.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biskot.domain.model.Cart;
import com.biskot.infra.repository.InMemoryCartRepository;

@Service // a service
public class CartServiceImpl implements CartService {
    

	@Autowired 
	InMemoryCartRepository cartRepo;
	
	@Override
    public void createCart(Cart cart) {
        
		cartRepo.saveCart(cart);
    }

    @Override
    public Cart getCart(int cartId) {
    	return cartRepo.getCart(cartId);
         
    }

    @Override
    public void addItemToCart(int cartId, int product_id, int quantity) {
    	cartRepo.addItemToCart(cartId, product_id, quantity);
    }
    
    @Override
    public List<Cart> getAllCarts(){
    	return cartRepo.getAllCarts();
    }
    
    @Override
    public void putItemToCart(int cartId, int product_id, int quantity) {
    	cartRepo.putItemToCart(cartId, product_id, quantity);
    }
    
  

}
