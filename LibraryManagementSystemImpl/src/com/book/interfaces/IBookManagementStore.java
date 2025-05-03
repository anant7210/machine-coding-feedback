package com.book.interfaces;

import java.util.List;

import com.common.BookCopyDetails;
import com.common.enums.SearchAttribute;
import com.exception.LibraryManagementException;

public interface IBookManagementStore {
	
	List<BookCopyDetails> search(SearchAttribute attributeName, String value) throws LibraryManagementException;
	
	BookCopyDetails borrowBookCopy(String bookCopyId) throws LibraryManagementException;
	
	boolean canBorrowBookCopy(String bookCopyId) throws LibraryManagementException;
	
	boolean returnBook(String bookCopyId) throws LibraryManagementException;
	
}
