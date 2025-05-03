package com.user;

import java.util.HashMap;

import com.common.UserDetails;
import com.exception.LibraryManagementException;
import com.exception.UserIDAlreadyPresentException;
import com.exception.UserNotFoundException;
import com.user.interfaces.IUserDataStore;

public class UserDataStore implements IUserDataStore {
	
	private HashMap<String, UserDetails> idUserDetailsMap;

	@Override
	public UserDetails getUserDetails(String userId) throws LibraryManagementException {
		if (!this.idUserDetailsMap.containsKey(userId)) {
			throw new UserNotFoundException();
		}
		
		return this.idUserDetailsMap.get(userId);
	}

	@Override
	public UserDetails addUserDetails(UserDetails userDetails) throws LibraryManagementException {
		if (this.idUserDetailsMap.containsKey(userDetails.getID())) {
			throw new UserIDAlreadyPresentException();
		}
		
		this.idUserDetailsMap.put(userDetails.getID(), UserDetails.createCopy(userDetails));
		
		return this.idUserDetailsMap.get(userDetails.getID());
	}

	@Override
	public boolean deleteUser(String userID) throws LibraryManagementException {
		// TODO Auto-generated method stub
		if (!this.idUserDetailsMap.containsKey(userID)) {
			throw new UserNotFoundException();
		}
		
		this.idUserDetailsMap.remove(userID);
		
		return true;
	}

}
