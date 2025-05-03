package com.user.interfaces;

import java.util.HashSet;

import com.exception.LibraryManagementException;

public interface IUserActivityDataStore {
	boolean updateBorrowedBookDetails(String userID, String bookCopyId) throws LibraryManagementException;
	
	boolean canBorrowBook(String userid) throws LibraryManagementException;
	
	boolean returnBookCopy(String bookCopyId) throws LibraryManagementException;
	
	HashSet<String> getBorrowedBooks(String userId) throws LibraryManagementException;
}
