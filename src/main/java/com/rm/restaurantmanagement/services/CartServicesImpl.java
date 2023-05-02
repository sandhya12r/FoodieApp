package com.rm.restaurantmanagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rm.restaurantmanagement.entity.CartEntity;
import com.rm.restaurantmanagement.model.Cart;
import com.rm.restaurantmanagement.repository.CartEntityRepository;

@Service
public class CartServicesImpl implements CartServices{
	
	@Autowired
	CartEntityRepository cartEntityRepository;
	
	@Override
	public Cart addToCart(Cart cart) {
		CartEntity cartEntity = new CartEntity();
		List<CartEntity> cartEntityPresent = cartEntityRepository.findAll();
		for(CartEntity ce: cartEntityPresent) {
			if(ce.getDishId() == cart.getDishId() && ce.getCartId().equals(cart.getCartId())) {
//				System.out.println(ce.getName());
				cartEntity = ce;
				cartEntity.setInCart(ce.getInCart()+1);
				cartEntity = cartEntityRepository.save(cartEntity);
				cart.setId(cartEntity.getId());
				return cart;
			}
		}
		BeanUtils.copyProperties(cart, cartEntity);
		cartEntity.setInCart(1);
		cartEntity = cartEntityRepository.save(cartEntity);
		cart.setId(cartEntity.getId());
		return cart;
	}

	@Override
	public List<Cart> getCart(String userId) {
		List<CartEntity> cartEntities = cartEntityRepository.findAll();
		List<CartEntity> personalCartEnities = new ArrayList<>();
		for(CartEntity ce: cartEntities) {
			if(ce.getCartId().equals(userId)) {
				personalCartEnities.add(ce);
			}
		}
		List<Cart> cart = new ArrayList<>();
		cart = personalCartEnities.stream().map((cartEntity)->Cart.builder()
				.id(cartEntity.getId())
				.cartId(cartEntity.getCartId())
				.DishId(cartEntity.getDishId())
				.name(cartEntity.getName())
				.photo(cartEntity.getPhoto())
				.price(cartEntity.getPrice())
				.inCart(cartEntity.getInCart())
				.build()).collect(Collectors.toList());
		return cart;
	}

	@Override
	public Cart removeFromCart(String dishId) {
		CartEntity cartEntity = cartEntityRepository.getById(dishId);
		Cart cart = new Cart();
		if(cartEntity.getInCart()>1) {
			cartEntity.setInCart(cartEntity.getInCart()-1);
			cartEntityRepository.save(cartEntity);
		}else {
			cartEntityRepository.deleteById(dishId);
		}
		BeanUtils.copyProperties(cartEntity, cart);
		return cart;
	}

}
