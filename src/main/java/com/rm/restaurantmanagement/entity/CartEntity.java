package com.rm.restaurantmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="cart")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name= "uuid", strategy="uuid2")
	private String id;
	@Lob
	private String cartId;
	private int dishId;
	private String name;
	@Lob
	private String photo;
	private String price;
	private int inCart;
	
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name="name", nullable=true)
//	private DishEntity dishEntity;
//	@Lob
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="photo", nullable=true)
//	private DishEntity dishEntity;
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="price", nullable=true)
//	private DishEntity dishEntity;
}
