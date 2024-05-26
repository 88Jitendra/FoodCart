package com.foodcart.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.foodcart.dao.FoodDAO;
import com.foodcart.entity.Order;
import com.foodcart.entity.Restaurant;
import com.foodcart.entity.User;
public class FoodCartService {
	private FoodDAO foodDAO;
	private User activeUser;
	
    public FoodCartService(){
    	foodDAO = new FoodDAO();
    }
    
    public void registerUser(String name, String gender, Integer number, String pincode)
    {
    	User user = new User(name,gender,number,pincode);
    	foodDAO.getRegisteredUser().put(user.getMobileNumber(), user);
    	System.out.println(user.getMobileNumber() + " registered successfully");
    }
    
    public void loginUser(Integer userId)
    {
    	if(!foodDAO.getRegisteredUser().containsKey(userId))
    	{
    		System.out.println("User not registered , first register by yourself");
    		return;
    	}
    	activeUser = foodDAO.getRegisteredUser().get(userId);
    	System.out.println("User logged in as : name " + activeUser.getName());
    }
    
    public void registerRestaurant(String name, Set<String> serviceCode, String item, Integer price, Integer quantity)
    {
       if(activeUser == null)
       {
    		System.out.println("First login in system ");
    		return ;
       }
       Restaurant newRestaurant = new Restaurant(name, serviceCode, item, price, quantity);
       if(foodDAO.getRestaurantMap().get(activeUser) == null)
       {
    	   foodDAO.getRestaurantMap().put(activeUser, new ArrayList<>());
       }
       foodDAO.getRestaurantMap().get(activeUser).add(newRestaurant);
       System.out.println("Restaurant added for user : "+ activeUser.getName());
    }
    
    public void updateQuantity(String name, Integer quantity)
    {
    	if(activeUser == null)
    	{
    		System.out.println("First login in system ");
    		return ;
    	}
    	List<Restaurant> oldRestaurant = foodDAO.getRestaurantMap().get(activeUser);
    	for(Restaurant restaurant : oldRestaurant)
    	{
    		if(restaurant.getName().compareTo(name) == 0)
    		{
    			restaurant.setQuantity(restaurant.getQuantity()+quantity);
    			System.out.println(" For : " + name + " Quantity update");
    			return;
    		}
    	}
    	System.out.println("Restaurant not found try for correct name : ");
    	return;
    }
    
    public void rateRestaurant(String name, Integer rating, String comment)
    {
    	if(activeUser == null)
    	{
    		System.out.println("First login in system ");
    		return ;
    	}
    	List<Restaurant> oldRestaurant = foodDAO.getRestaurantMap().get(activeUser);
    	for(Restaurant restaurant : oldRestaurant)
    	{
    		if(restaurant.getName().compareTo(name) == 0)
    		{
    			restaurant.setRating(rating);
    			List<String> comments = restaurant.getComments();
    			comments.add(comment);
    			restaurant.setComments(comments);
    			System.out.println(" For : " + name + " rating and comment updated");
    			return;
    		}
    	}
    	System.out.println("Restaurant not found try for correct name : ");
    	return;
    }
    
    public List<Restaurant> getRestaurantBasedRating(Integer rating)
    {
    	if(activeUser == null)
    	{
    		System.out.println("First login in system ");
    		return new ArrayList<>();
    	}
    	List<Restaurant> allRestaurant = foodDAO.getRestaurantMap().get(activeUser);
    	List<Restaurant> myRestaurant = new ArrayList<>();
    	
    	for(Restaurant restaurant : allRestaurant)
    	{
    		if(restaurant.getRating() == rating && (restaurant.getServicableArea().contains(activeUser.getPincode())))
    		{
    			System.out.println("Found restaurant based on rating:");
    			myRestaurant.add(restaurant);
    		}
    	}
    	Collections.sort(myRestaurant, (a, b) -> (a.getName()).compareTo(b.getName())==0?(a.getPrice()-b.getPrice()) : (b.getName()).compareTo(a.getName()));
    	return myRestaurant;
    }
    
    public List<Restaurant> getRestaurantBasedPrice(Integer price)
    {
    	if(activeUser == null)
    	{
    		System.out.println("First login in system ");
    		return new ArrayList<>();
    	}
    	List<Restaurant> allRestaurant = foodDAO.getRestaurantMap().get(activeUser);
    	List<Restaurant> myRestaurant = new ArrayList<>();
    	
    	for(Restaurant restaurant : allRestaurant)
    	{
    		if((restaurant.getPrice().equals(price) == true) && (restaurant.getServicableArea().contains(activeUser.getPincode()) == true ))
    		{
    			System.out.println("Found restaurant based on price:");
    			myRestaurant.add(restaurant);
    		}
    	}
    	Collections.sort(myRestaurant, (a, b) -> (a.getName()).compareTo(b.getName())==0?(a.getPrice()-b.getPrice()) : (b.getName()).compareTo(a.getName()));
    	return myRestaurant;
    }
    
    public void placeOrder(String name, Integer quantity)
    {
    	if(activeUser == null)
    	{
    		System.out.println("First login in system ");
    		return ;
    	}
    	List<Restaurant> allRestaurant = foodDAO.getRestaurantMap().get(activeUser);
    	
    	for(Restaurant restaurant : allRestaurant)
    	{
    		if(((restaurant.getName().compareTo(name)) == 0) && (restaurant.getQuantity() >= quantity))
    		{
    			System.out.println("Order place successfull from restaurant : " + restaurant.getName());
    			restaurant.setQuantity(restaurant.getQuantity()-quantity);
    			if(foodDAO.getOrderHistory().get(activeUser) == null)
    		    foodDAO.getOrderHistory().put(activeUser, new ArrayList<>());
    			
    			foodDAO.getOrderHistory().get(activeUser).add(new Order(name,new Date(), quantity));
    			return;
    		}
    	}
    	System.out.println("Restaurant not found try for correct name : ");
    	return;
    }
    public List<Order> getOrderHistory()
    {
    	return foodDAO.getOrderHistory().get(activeUser);
    }
}