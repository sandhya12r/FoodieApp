package com.rm.restaurantmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="dishes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DishEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	@Lob
	private String description;
	private String price;
	private String cuisine;
	@Lob
	private String photo;
	private String rating;
	private String time;
	private String tag;
	
//	@ManyToOne(cascade=CascadeType.ALL, targetEntity = CartEntity.class)
//	private CartEntity cartEntity;
}
