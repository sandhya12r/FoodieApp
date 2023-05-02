package com.rm.restaurantmanagement.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rm.restaurantmanagement.entity.CartEntity;


@Repository
public interface CartEntityRepository extends JpaRepository<CartEntity, String>{
	@Query(value = "SELECT c.id, d.id AS dish_id, d.name, d.photo, d.price, d.time FROM dishes d LEFT JOIN cart c ON c.dish_id = d.id WHERE c.cart_id = :userId",
			nativeQuery = true
			)
	CartEntity getPersonalCart(@Param("userId") String id);
}
