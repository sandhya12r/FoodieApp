package com.rm.restaurantmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rm.restaurantmanagement.entity.DishEntity;

public interface DishEntityRepository extends JpaRepository<DishEntity, Integer>{

}
