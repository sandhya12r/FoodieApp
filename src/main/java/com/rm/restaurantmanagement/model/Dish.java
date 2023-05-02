package com.rm.restaurantmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
	private int id;
	private String name;
	private String description;
	private String price;
	private String cuisine;
	private String photo;
	private String rating;
	private String time;
	private String tag;
}
