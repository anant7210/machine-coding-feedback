package com.dataStore;

public class UserDetails {

	String userId;
	String name;
	
	String email;
	
	String phoneNumber;
	
	public UserDetails(String userId, String name, String email, String phoneNumber) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
