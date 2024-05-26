package com.foodcart.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Restaurant {
    private String name;
    private Set<String> servicableArea;
    private String foodItem;
    private Integer price;
    private Integer quantity;
    private double rating;
    private static Integer userCount = 0;
    private List<String> comments;
	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		if(userCount == 0)
		{
			userCount++;
			this.rating = (double)rating;
		}
		else
		{
			this.rating = (double)((rating*userCount)+rating)/(userCount+1);
			userCount++;
		}
		
	}
	public Restaurant(String name, Set<String> servicableArea, String foodItem, Integer price, Integer quantity) {
		this.name = name;
		this.servicableArea = servicableArea;
		this.foodItem = foodItem;
		this.price = price;
		this.quantity = quantity;
		this.comments = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getServicableArea() {
		return servicableArea;
	}
	public void setServicableArea(Set<String> servicableArea) {
		this.servicableArea = servicableArea;
	}
	public String getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Restaurant Name : " + name + "Item " + foodItem + " Quantity : " + quantity;
	}
    
}
