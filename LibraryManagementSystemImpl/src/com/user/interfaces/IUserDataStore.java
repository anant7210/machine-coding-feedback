package com.user.interfaces;

import com.common.UserDetails;
import com.exception.LibraryManagementException;

public interface IUserDataStore {
	
	UserDetails getUserDetails(String userId) throws LibraryManagementException;
	
	UserDetails addUserDetails(UserDetails userDetails) throws LibraryManagementException;
	
	boolean deleteUser(String userID) throws LibraryManagementException;
}
