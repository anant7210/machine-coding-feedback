package com.application.interfaces;

import java.util.List;

import com.common.BookSearchResult;
import com.common.enums.SearchAttribute;
import com.exception.LibraryManagementException;

public interface ILibraryManagementSystem {
	
	boolean addBook(int bookId, String bookName, List<String> authorList, List<String> publisher, List<String> bookCopyIds) throws LibraryManagementException;
	
	boolean removeBookCopy(String bookCopyId) throws LibraryManagementException;
	
	boolean borrowBook(int bookId, String userId, String dueDate) throws LibraryManagementException;
	
	boolean borrowBookCopy(String bookCopyId, String userId, String dueDate) throws LibraryManagementException;
	
	boolean returnBookCopy(String bookCopyId) throws LibraryManagementException;
	
	List<String[]> printBorrowedBook(String userId) throws LibraryManagementException;
	
	BookSearchResult search(SearchAttribute attribute, String value) throws LibraryManagementException;
}
