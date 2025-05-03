package com.libraryManangement.interfaces;

import com.common.BookCopyDetails;
import com.exception.LibraryManagementException;

public interface ILibraryManagementDataStore {
	boolean addBookCopyToRack(BookCopyDetails bookCopyDetails) throws LibraryManagementException;
	
	boolean removeBookCopyFromRack(String bookCopyID) throws LibraryManagementException;
}
