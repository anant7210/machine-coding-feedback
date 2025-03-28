package com.dataStore;

import java.util.HashMap;

import com.interfaces.IUserDataStore;

public class UserDataStore implements IUserDataStore {
	HashMap<String, UserDetails> userDetailMap = new HashMap<String, UserDetails>();
	@Override
	public UserDetails getUserDetails(String userId) {
		// TODO Auto-generated method stub
		return this.userDetailMap.get(userId);
	}

	@Override
	public boolean addNewUser(UserDetails userDetails) {
		if (userDetails != null && userDetails.getUserId() != null && !userDetails.getUserId().equals("")) {
			this.userDetailMap.put(userDetails.getUserId(), userDetails);
			
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteUser(String userId) {
		if (userId != null && !userId.equals("")) {
			this.userDetailMap.remove(userId);
			
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUserDetails(String userId, UserDetails userDetails) {
		if (userId != null && !userId.equals("") && userDetails != null) {
			if (userDetails.getName() != null) {
				this.userDetailMap.get(userId).setName(userDetails.getName());
			}
			
			if (userDetails.getEmail() != null) {
				this.userDetailMap.get(userId).setEmail(userDetails.getEmail());
			}
			
			if (userDetails.getPhoneNumber() != null) {
				this.userDetailMap.get(userId).setPhoneNumber(userDetails.getPhoneNumber());
			}
			
			return true;
		}
		return false;
	}

}
