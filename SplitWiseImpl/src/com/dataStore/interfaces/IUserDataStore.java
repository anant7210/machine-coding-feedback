package com.dataStore.interfaces;

import com.user.UserDetails;

public interface IUserDataStore {
	UserDetails getUserDetails(String userId);
	
	boolean addNewUser(UserDetails userDetails);
	
	boolean deleteUser(String userId);
	
	boolean updateUserDetails(String userId, UserDetails userDetails);
}
