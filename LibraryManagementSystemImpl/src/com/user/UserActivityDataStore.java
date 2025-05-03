package com.user;

import java.util.HashMap;
import java.util.HashSet;

import com.exception.BookCopyNotBorrowedByUserException;
import com.exception.LibraryManagementException;
import com.exception.UserOverLimitException;
import com.user.interfaces.IUserActivityDataStore;
import com.user.interfaces.IUserDataStore;

public class UserActivityDataStore implements IUserActivityDataStore {
	
	private IUserDataStore userDataStore;
	
	private HashMap<String, HashSet<String>> userBorrowedBooksMap;
	
	HashMap<String, String> bookCopyUserMap;
	
	private int maxBookBorrowed;
	
	

	public UserActivityDataStore(IUserDataStore userDataStore, int maxBookBorrowed) {
		this.userDataStore = userDataStore;
		this.maxBookBorrowed = maxBookBorrowed;
	}

	@Override
	public boolean updateBorrowedBookDetails(String userID, String bookCopyId) throws LibraryManagementException {
		if (!canBorrowBook(userID)) {
			throw new UserOverLimitException();
		}
		
		if (userDataStore.getUserDetails(userID) == null) {
			return false;
		}
		
		if (!this.userBorrowedBooksMap.containsKey(userID)) {
			this.userBorrowedBooksMap.put(userID, new HashSet<String>());
		}
		
		this.userBorrowedBooksMap.get(userID).add(bookCopyId);
		
		this.bookCopyUserMap.put(bookCopyId, userID);
		
		return true;
	}

	@Override
	public boolean canBorrowBook(String userid) throws LibraryManagementException {
		if (this.userBorrowedBooksMap.containsKey(userid) && this.userBorrowedBooksMap.get(userid).size() == this.maxBookBorrowed) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean returnBookCopy(String bookCopyId) throws LibraryManagementException {
		if (!this.bookCopyUserMap.containsKey(bookCopyId)) {
			throw new BookCopyNotBorrowedByUserException();
		}
		
		this.userBorrowedBooksMap.get(this.bookCopyUserMap.get(bookCopyId)).remove(bookCopyId);
		
		this.bookCopyUserMap.remove(bookCopyId);
		
		return true;
	}

	@Override
	public HashSet<String> getBorrowedBooks(String userId) throws LibraryManagementException {
		if (this.userDataStore.getUserDetails(userId) == null) {
			return null;
		}
		
		if (!this.userBorrowedBooksMap.containsKey(userId)) {
			return new HashSet<String>();
		}
		
		return this.userBorrowedBooksMap.get(userId);
	}

}
