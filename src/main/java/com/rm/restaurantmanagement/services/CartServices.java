package com.rm.restaurantmanagement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rm.restaurantmanagement.model.Cart;

@Service
public interface CartServices {
	
	Cart addToCart(Cart cart);

	List<Cart> getCart(String userId);

	Cart removeFromCart(String dishId);
	
}
