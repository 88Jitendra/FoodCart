package com.foodcart.entity;

public class User {
	private int id;
	private String name;
	private int mobileNumber;
	private String pincode;
	private String gender;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public User(String name, String gender, int mobileNumber, String pincode) {
		this.id = mobileNumber;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.pincode = pincode;
		this.gender = gender;
	}
	
	
}
