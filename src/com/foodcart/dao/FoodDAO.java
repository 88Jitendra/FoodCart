package com.foodcart.dao;

import java.util.HashMap;
import java.util.List;

import com.foodcart.entity.Order;
import com.foodcart.entity.Restaurant;
import com.foodcart.entity.User;

public class FoodDAO {

	private HashMap<User, List<Restaurant>> restaurantMap;
	private HashMap<User, List<Order>> orderHistory;
    private HashMap<Integer, User> registeredUser;
	public FoodDAO()
	{
		restaurantMap = new HashMap<>();
		orderHistory = new HashMap<>();
		registeredUser = new HashMap<>();
	}
	public HashMap<Integer, User> getRegisteredUser() {
		return registeredUser;
	}
	public void setRegisteredUser(HashMap<Integer, User> registeredUser) {
		this.registeredUser = registeredUser;
	}
	public HashMap<User, List<Order>> getOrderHistory() {
		return orderHistory;
	}
	public void setOrderHistory(HashMap<User, List<Order>> orderHistory) {
		this.orderHistory = orderHistory;
	}
	public HashMap<User, List<Restaurant>> getRestaurantMap() {
		return restaurantMap;
	}

	public void setRestaurantMap(HashMap<User, List<Restaurant>> restaurantMap) {
		this.restaurantMap = restaurantMap;
	}
		
}
