package com.interfaces;

import com.dataStore.UserDetails;

public interface IUser {
	UserDetails getUserDetails(String userId);
	
	boolean updateUserDetails(String userId, UserDetails userDetails);
}
