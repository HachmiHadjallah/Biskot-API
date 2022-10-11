package com.biskot.domain.spi;

import com.biskot.domain.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartPersistencePort {

    Cart getCart(int id);
    void saveCart(Cart cart);
    void addItemToCart(int cartId, int productId, int quantityToAdd);
	List<Cart> getAllCarts();
	void putItemToCart(int cartId, int productId, int quantityToAdd);


}
