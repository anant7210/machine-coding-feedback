package com.user.interfaces;

import com.common.UserDetails;
import com.exception.TrelloException;

public interface IUserDataStore {
	
	UserDetails getUserDetails(String userId) throws TrelloException;
	
	UserDetails addUserDetails(UserDetails userDetails) throws TrelloException;
	
	UserDetails removeUser(String userId) throws TrelloException;
}
