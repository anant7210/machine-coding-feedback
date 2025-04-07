package com.user.interfaces;

import com.user.UserDetails;

public interface IUser {
	UserDetails getUserDetails(String userId);
	
	boolean updateUserDetails(String userId, UserDetails userDetails);
}
