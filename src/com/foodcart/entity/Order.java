package com.foodcart.entity;

import java.util.Date;

public class Order {
	private String restaurantName;
	private Date orderDate;
	public Order(String restaurantName, Date orderDate, Integer quantity) {
		this.restaurantName = restaurantName;
		this.orderDate = orderDate;
		this.quantity = quantity;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getQuantity() {
		return quantity;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Restaurant Name : " + restaurantName + " Date : " + orderDate;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	private Integer quantity;
}
