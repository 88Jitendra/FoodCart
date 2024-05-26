package com.foodcart.driver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.foodcart.service.FoodCartService;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         FoodCartService  foodCartService = new FoodCartService();
         Scanner scanner = new Scanner(System.in);
         System.out.println("Welcome to food cart service");
         outer : while(true)
         {
        	 System.out.println("Enter your choice:");
        	 System.out.println("1. Register user ");
        	 System.out.println("2. Login user ");
        	 System.out.println("3. Register Restaurant ");
        	 System.out.println("4. Update Restaurant ");
        	 System.out.println("5. Rate Restaurant ");
        	 System.out.println("6. Show Restaurant base on price");
        	 System.out.println("7. Show Restaurant base on rating");
        	 System.out.println("8. Place order ");
        	 System.out.println("9. Show user order ");
        	 System.out.println("10. Exit");
        	 int input = scanner.nextInt();
        	 switch(input)
        	 {
        	 	case 1: System.out.println("Enter user details ");
        	 			System.out.println(" Eneter name :");
        	 			String name = scanner.next();
        	 			System.out.println(" Enter Gender :");
        	 			String gender = scanner.next();
        	 			System.out.println(" Enter phone number: ");
        	 			int number  = scanner.nextInt();
        	 			System.out.println(" Enter pin code : ");
        	 			String pincode = scanner.next();
        	 			foodCartService.registerUser(name, gender, number, pincode);
        	 			break;
        	 	case 2: System.out.println("Enter user details ");
	 					System.out.println(" Enter user id as mobile number : ");
	 					Integer userId  = (Integer)scanner.nextInt();
	 					foodCartService.loginUser(userId);
	 					break;
        	 	case 3: System.out.println("Enter user details ");
	 					System.out.println(" Eneter Restaurant name :");
	 					String restaurant = scanner.next();
	 					System.out.println(" Enter Pincode :");
	 					String pinCode = scanner.next();
	 					String[] allPinCode = pinCode.split("/");
	 					Set<String> restaurantPinCode = new HashSet<>(Arrays.asList(allPinCode));
	 					System.out.println(" Enter Item name: ");
	 					String item = scanner.next();
	 					System.out.println(" Enter Price : ");
	 					int price  = scanner.nextInt();
	 					System.out.println(" Enter Quantity : ");
	 					int quantity = scanner.nextInt();
	 					foodCartService.registerRestaurant(restaurant, restaurantPinCode, item, price, quantity);
	 					break;
        	 	case 4: System.out.println(" Eneter Restaurant name :");
        	 			String restName = scanner.next();
        	 			System.out.println("Enter Quantity to add : ");
        	 			Integer newQuantity = scanner.nextInt();
        	 			foodCartService.updateQuantity(restName, newQuantity);
        	 			break;
        	 	case 5: System.out.print("Enter Restaurant Name: ");
	 	        		String nameRestaurant = scanner.next();
	 	        		System.out.println("Enter rating : ");
	 	        		int rating = scanner.nextInt();
	 	        		System.out.println("Enter comment : ");
	 	        		String comment = scanner.next();
	 	        		foodCartService.rateRestaurant(nameRestaurant, rating, comment);
	 	        		break;
        	 	case 6: System.out.println("Enter price : ");
	 					int priceBase = scanner.nextInt();
	 					System.out.println(foodCartService.getRestaurantBasedPrice(priceBase));
	 					break;
        	 	case 7: System.out.println("Enter rating : ");
						int ratingBase = scanner.nextInt();
						System.out.println(foodCartService.getRestaurantBasedRating(ratingBase));
						break;
        	 	case 8: System.out.println("Enter restaurant name :");
        	 			String orderRestaurantName = scanner.next();
        	 			System.out.println(" Enter quantity: ");
        	 			int quantityOrder = scanner.nextInt();
        	 			foodCartService.placeOrder(orderRestaurantName, quantityOrder);
        	 			break;
        	 	case 9: System.out.println(foodCartService.getOrderHistory());
        	 			break;
        	 	case 10: break outer;
        	 }
         }
         scanner.close();
	}

}
