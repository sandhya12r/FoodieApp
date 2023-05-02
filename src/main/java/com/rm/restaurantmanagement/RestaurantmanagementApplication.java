package com.rm.restaurantmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.rm.restaurantmanagement.services.CartServices")
public class RestaurantmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantmanagementApplication.class, args);
	}

}
