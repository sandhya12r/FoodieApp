package com.rm.restaurantmanagement.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rm.restaurantmanagement.entity.DishEntity;
import com.rm.restaurantmanagement.model.Dish;
import com.rm.restaurantmanagement.repository.DishEntityRepository;

@Service
public class DishServicesImpl implements DishServices{
	
	@Autowired
	DishEntityRepository dishEntityRepository;
	
	public DishServicesImpl(DishEntityRepository dishEntityRepository) {
		this.dishEntityRepository = dishEntityRepository;
	}

	@Override
	public Dish createDish(Dish dish) {
		DishEntity dishEntity = new DishEntity();
		BeanUtils.copyProperties(dish, dishEntity);
		dishEntity = dishEntityRepository.save(dishEntity);
		dish = Dish.builder()
				.id(dishEntity.getId())
				.name(dishEntity.getName())
				.description(dishEntity.getDescription())
				.price(dishEntity.getPrice())
				.cuisine(dishEntity.getCuisine())
				.photo(dishEntity.getPhoto())
				.rating(dishEntity.getRating())
				.time(dishEntity.getTime())
				.build();
		return dish;
	}

	@Override
	public List<Dish> getAll() {
		List<DishEntity> dishEntities =  dishEntityRepository.findAll();
		List<Dish> dishes = new ArrayList<>();
		dishes = dishEntities.stream().map((dishEntity) -> Dish.builder()
				.id(dishEntity.getId())
				.name(dishEntity.getName())
				.description(dishEntity.getDescription())
				.price(dishEntity.getPrice())
				.cuisine(dishEntity.getCuisine())
				.photo(dishEntity.getPhoto())
				.rating(dishEntity.getRating())
				.time(dishEntity.getTime())
				.tag(dishEntity.getTag())
				.build()).collect(Collectors.toList());
		return dishes;
	}

	@Override
	public List<Dish> getAllHighToLow() {
		List<DishEntity> dishEntities =  dishEntityRepository.findAll();
		List<Dish> dishes = new ArrayList<>();
		dishes = dishEntities.stream().map((dishEntity) -> Dish.builder()
				.id(dishEntity.getId())
				.name(dishEntity.getName())
				.description(dishEntity.getDescription())
				.price(dishEntity.getPrice())
				.cuisine(dishEntity.getCuisine())
				.photo(dishEntity.getPhoto())
				.rating(dishEntity.getRating())
				.time(dishEntity.getTime())
				.tag(dishEntity.getTag())
				.build()).collect(Collectors.toList());
//		for(int i = 0; i < dishes.size() - 1; i++) {
//			int pricei = Integer.valueOf(dishes.get(i).getPrice());
//			for(int j = 0; j < dishes.size()- i- 1; j++) {
//				int pricei1 = Integer.valueOf(dishes.get(j).getPrice());
//				if (pricei > pricei1) {
//					Dish temp = new Dish();
//					temp = dishes.get(i);
//					dishes.set(i, dishes.get(j));
//					dishes.set(j, temp);
//				}
//			}
//			
//		}
		 Collections.sort(dishes, new Comparator<Dish>() {

				@Override
				public int compare(Dish o1, Dish o2) {
					int p1 = Integer.valueOf(o1.getPrice());
					int p2 = Integer.valueOf(o2.getPrice());
					return p2 - p1;
				}
	        });
		return dishes;
	}

	@Override
	public List<Dish> getAllLowToHigh() {
		List<DishEntity> dishEntities =  dishEntityRepository.findAll();
		List<Dish> dishes = new ArrayList<>();
		dishes = dishEntities.stream().map((dishEntity) -> Dish.builder()
				.id(dishEntity.getId())
				.name(dishEntity.getName())
				.description(dishEntity.getDescription())
				.price(dishEntity.getPrice())
				.cuisine(dishEntity.getCuisine())
				.photo(dishEntity.getPhoto())
				.rating(dishEntity.getRating())
				.time(dishEntity.getTime())
				.tag(dishEntity.getTag())
				.build()).collect(Collectors.toList());
		
		 Collections.sort(dishes, new Comparator<Dish>() {

				@Override
				public int compare(Dish o1, Dish o2) {
					int p1 = Integer.valueOf(o1.getPrice());
					int p2 = Integer.valueOf(o2.getPrice());
					return p1 - p2;
				}
	        });
		return dishes;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Dish delete(int id) {
		DishEntity dishEntity = new DishEntity();
		dishEntity = dishEntityRepository.getById(id);
		dishEntityRepository.deleteById(id);
		Dish dish = new Dish();
		BeanUtils.copyProperties(dishEntity, dish);
		return dish;
	}

	@Override
	public Dish modifyDish(Dish dish) {
		DishEntity dishEntity = new DishEntity();
		Dish oldDish = new Dish();
		dishEntity = dishEntityRepository.getById(dish.getId());
		dishEntity.setName(dish.getName());
		dishEntity.setCuisine(dish.getCuisine());
		dishEntity.setPrice(dish.getPrice());
		dishEntity.setTag(dish.getTag());
		dishEntity.setTime(dish.getTime());
		dishEntity = dishEntityRepository.save(dishEntity);
		BeanUtils.copyProperties(dishEntity, oldDish);
		return oldDish;
	}

}
