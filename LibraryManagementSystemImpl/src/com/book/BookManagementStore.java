package com.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.book.interfaces.IBookManagementStore;
import com.book.interfaces.IBookStore;
import com.common.BookCopyDetails;
import com.common.BookDetails;
import com.common.enums.SearchAttribute;
import com.exception.BookCopyAlreadyBorrowedException;
import com.exception.BookCopyNotBorrowedByUserException;
import com.exception.LibraryManagementException;
import com.exception.NoResultsFoundException;

public class BookManagementStore implements IBookManagementStore {
	
	private	HashMap<SearchAttribute, HashMap<String, HashSet<BookDetails>>> attributeValueBookMap;
	
	private IBookStore bookStore;
	
	private HashSet<String> borrowedBookIDs;
	
	
	

	public BookManagementStore(IBookStore bookStore) {
		this.bookStore = bookStore;
	}

	@Override
	public List<BookCopyDetails> search(SearchAttribute attributeName, String value) throws LibraryManagementException {
		if (!this.attributeValueBookMap.get(attributeName).containsKey(value)) {
			throw new NoResultsFoundException();
		}
		
		List<BookCopyDetails> result = new ArrayList<BookCopyDetails>();
		
		Iterator<BookDetails> it = this.attributeValueBookMap.get(attributeName).get(value).iterator();
		
		while (it.hasNext()) {
			result.addAll(new HashSet<>(it.next().getCopies()));
		}
		
		return result;
	}

	@Override
	public BookCopyDetails borrowBookCopy(String bookCopyId) throws LibraryManagementException {
		if (!this.canBorrowBookCopy(bookCopyId)) {
			throw new BookCopyAlreadyBorrowedException();
		}
		
		this.bookStore.getBookCopyDetails(bookCopyId).setAsBorrowed();
		
		borrowedBookIDs.add(bookCopyId);
		
		
		return this.bookStore.getBookCopyDetails(bookCopyId);
	}

	@Override
	public boolean canBorrowBookCopy(String bookCopyId) throws LibraryManagementException {
		if (this.bookStore.getBookCopyDetails(bookCopyId) == null) {
			return false;
		}
		
		if (this.borrowedBookIDs.contains(bookCopyId)) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean returnBook(String bookCopyId) throws LibraryManagementException {
		if (this.bookStore.getBookCopyDetails(bookCopyId) == null) {
			return false;
		}
		
		if (!this.borrowedBookIDs.contains(bookCopyId)) {
			throw new BookCopyNotBorrowedByUserException();
		}
		
		this.borrowedBookIDs.remove(bookCopyId);
		
		return true;
	}

}
