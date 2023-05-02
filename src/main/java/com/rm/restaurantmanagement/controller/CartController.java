package com.rm.restaurantmanagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rm.restaurantmanagement.model.Cart;
import com.rm.restaurantmanagement.services.CartServices;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/v1/cart")
public class CartController {
	
	
	@Autowired
	CartServices cartServices;
	
	public CartController(CartServices cs) {
		this.cartServices = cs;
	}
	
	@GetMapping("/getcart")
	public String getCart() {
		return "Get endpoint hit";
	}
	
	@PostMapping
	public List<Cart> getYourCart(@RequestParam Map<String, String> param){
//		System.out.println("Personal Cart Endpoint Hit");
		String userId = param.get("id");
		List<Cart> cart = cartServices.getCart(userId);
		return cart;
	}
	
	@PostMapping("/addtocart")
	public Cart addCart(@RequestParam Map<String, String> param) {
		String userId = param.get("id");
		String dishId = param.get("dishId");
		String name = param.get("name");
		String photo = param.get("photo");
		String price = param.get("price");
		int dishIdInt = Integer.parseInt(dishId);
		Cart cart = new Cart();
		cart = Cart.builder()
				.cartId(userId)
				.DishId(dishIdInt)
				.name(name)
				.photo(photo)
				.price(price)
				.build();
		cart = cartServices.addToCart(cart);
		return cart;
	}
	
	@DeleteMapping
	public Cart deleteCart(@RequestParam Map<String, String> param) {
		String dishId= param.get("cartId");
		Cart cart = cartServices.removeFromCart(dishId);
		
		return cart;
	}

}
