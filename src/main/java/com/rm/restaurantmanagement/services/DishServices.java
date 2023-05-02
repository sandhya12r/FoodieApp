package com.rm.restaurantmanagement.services;

import java.util.List;

import com.rm.restaurantmanagement.model.Dish;

public interface DishServices {

	public Dish createDish(Dish dish);

	public List<Dish> getAll();

	public List<Dish> getAllHighToLow();
	
	public List<Dish> getAllLowToHigh();

	public Dish delete(int idInt);

	public Dish modifyDish(Dish dish);
}
