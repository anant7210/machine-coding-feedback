package com.book.interfaces;

import com.common.BookCopyDetails;
import com.common.BookDetails;
import com.exception.LibraryManagementException;

public interface IBookStore {
	
	BookDetails getBookDetails(int bookID) throws LibraryManagementException;
	
	BookDetails addBook(BookDetails bookDetails) throws LibraryManagementException;
	
	boolean removeBookCopy(String bookCopyId) throws LibraryManagementException;
	
	BookCopyDetails getBookCopyDetails(String bookCopyId) throws LibraryManagementException;
	
}
