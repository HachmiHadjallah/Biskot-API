package com.biskot.app.rest;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.biskot.domain.model.Cart;
import com.biskot.domain.model.Item;
import com.biskot.domain.model.Product;
import com.biskot.domain.service.CartService;
import com.biskot.domain.spi.ProductPort;
import com.biskot.infra.repository.InMemoryCartRepository;




@RestController
public class CartController {
    
	
	@Autowired
	private CartService cartService;
	InMemoryCartRepository response = new InMemoryCartRepository();
	
	@GetMapping("/carts/{id}")
	public Cart getCart(@PathVariable int id){
      return cartService.getCart(id) ;
    }
	
	@GetMapping("/carts")
	public List<Cart> getAllCart(){
      return cartService.getAllCarts() ;
    }
	
	@PostMapping("/carts")
	public void addCart(@RequestBody Cart cart) {
		cartService.createCart(cart);
		
	}

	
	@PostMapping("/carts/{id}/items")
	public String addItemToCart(@PathVariable int id,@RequestBody Item item ) {
	    Item it= new Item();
	    it=item;
		cartService.addItemToCart(id, it.getProduct_id()-1, it.getQuantity());
		return response.getResponse();
	}
	
	@PutMapping("/carts/{id}/items")
	public String putItemToCart(@PathVariable int id ,@RequestBody Item item) {
		Item it= new Item();
	    it=item;
		cartService.putItemToCart(id, it.getProduct_id(), it.getQuantity());
		return response.getResponse();
	}

	
  
}
