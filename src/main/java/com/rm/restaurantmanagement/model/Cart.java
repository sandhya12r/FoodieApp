package com.rm.restaurantmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	private String id;
	private String cartId;
	private int DishId;
	private String name;
	private String photo;
	private String price;
	private int inCart;
}
