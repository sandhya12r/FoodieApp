package com.rm.restaurantmanagement.controller;

import java.util.ArrayList;
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

import com.rm.restaurantmanagement.model.Dish;
import com.rm.restaurantmanagement.repository.DishEntityRepository;
import com.rm.restaurantmanagement.services.DishServices;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/v1/dish")
public class DishController {
	
	@Autowired
	DishEntityRepository dishEntityRepository;
	
	@Autowired
	DishServices dishServices;
	
	public DishController(DishServices dishServices) {
		this.dishServices = dishServices;
	}
	
	@PostMapping
	public Dish addDish(@RequestParam Map<String, String> param) {
		System.out.println("Add Dish Endpoint hit");
		String name = param.get("name");
		String description = param.get("description");
		String price = param.get("price");
		String cuisine = param.get("cuisine");
		String tag = param.get("tag");
		String photo = param.get("photo");
		double choice = Math.random()*4;
		int rating = 0;
		if(choice < 1) {
			rating = 2;
		}else if(choice < 2) {
			rating = 3;
		}else if(choice < 3) {
			rating = 4;
		}else rating = 5;
		
		String time = param.get("time");
		Dish dish = new Dish();
		dish = Dish.builder()
				.name(name)
				.description(description)
				.photo(photo)
				.price(price)
				.cuisine(cuisine)
				.rating(String.valueOf(rating))
				.time(time)
				.tag(tag)
				.build();
		dish = dishServices.createDish(dish);
		System.out.println(dish);
		
		return dish;
	}
	
	@GetMapping
	public List<Dish> getAllDishes(){
		List<Dish> dishes = new ArrayList<>();
		dishes = dishServices.getAll();
		return dishes;
	}
	
	@GetMapping("/hightolow")
	public List<Dish> getAllDishesSortHighToLow(){
		List<Dish> dishes = new ArrayList<>();
		dishes = dishServices.getAllHighToLow();
		return dishes;
	}
	@GetMapping("/lowtohigh")
	public List<Dish> getAllDishesSortLowToHigh(){
		List<Dish> dishes = new ArrayList<>();
		dishes = dishServices.getAllLowToHigh();
		return dishes;
	}
	@DeleteMapping("/delete")
	public Dish deleteDish(@RequestParam Map<String,String> param) {
		String id = param.get("id");
		int idInt = Integer.parseInt(id);
		System.out.println("Delete Endpoint Hit");
		Dish dish = new Dish();
		dish = dishServices.delete(idInt);
		return dish;
	}
	@PostMapping("/modify")
	public Dish modifyDish(@RequestParam Map<String, String> param) {
		System.out.println("Modify Endpoint Hit");
		Dish dish = new Dish();
		String id = param.get("id");
		int idInt = Integer.parseInt(id);
		String name = param.get("name");
		String cuisine = param.get("cuisine");
		String price = param.get("price");
		String tag = param.get("tag");
		String time = param.get("time");
		dish = Dish.builder()
				.id(idInt)
				.name(name)
				.cuisine(cuisine)
				.price(price)
				.tag(tag)
				.time(time)
				.build();
		
		dish = dishServices.modifyDish(dish);
		System.out.println("Tag: "+ tag);
		System.out.println(id);
		
		return dish;
	}
	
}
