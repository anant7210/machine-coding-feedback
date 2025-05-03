package com.book;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.book.interfaces.IBookStore;
import com.common.BookCopyDetails;
import com.common.BookDetails;
import com.exception.BookIDAlreadyPresentException;
import com.exception.BookNotFoundException;
import com.exception.InvalidBookCopyIdException;
import com.exception.LibraryManagementException;

public class BookStore implements IBookStore {
	
	private HashMap<Integer, BookDetails> idBookMap;
	
	private HashMap<String, Integer> bookCopyBookMap;
	
	private HashMap<String, BookCopyDetails> idBookCopyMap;

	@Override
	public BookDetails getBookDetails(int bookID) throws LibraryManagementException {
		if (!this.idBookMap.containsKey(bookID)) {
			throw new BookNotFoundException();
		}
		
		
		return this.idBookMap.get(bookID);
	}

	@Override
	public BookDetails addBook(BookDetails bookDetails) throws LibraryManagementException {
		if (this.idBookMap.containsKey(bookDetails.getID())) {
			throw new BookIDAlreadyPresentException();
		}
		
		this.idBookMap.put(bookDetails.getID(), BookDetails.createCopy(bookDetails));
		
		HashSet<BookCopyDetails>  copies = this.idBookMap.get(bookDetails.getID()).getCopies();
		
		Iterator<BookCopyDetails> it = copies.iterator();
		
		while (it.hasNext()) {
			BookCopyDetails next = it.next();
			
			this.bookCopyBookMap.put(next.getID(), bookDetails.getID());
			this.idBookCopyMap.put(next.getID(), BookCopyDetails.createCopy(next));
		}
		
		return this.idBookMap.get(bookDetails.getID());
	}

	@Override
	public boolean removeBookCopy(String bookCopyId) throws LibraryManagementException {
		if (!this.bookCopyBookMap.containsKey(bookCopyId)) {
			throw new InvalidBookCopyIdException();
		}
		
		this.idBookMap.get(this.bookCopyBookMap.get(bookCopyId)).removeBookCopy(bookCopyId);
		
		this.bookCopyBookMap.remove(bookCopyId);
		
		return true;
	}

	@Override
	public BookCopyDetails getBookCopyDetails(String bookCopyId) throws LibraryManagementException {
		if (!this.bookCopyBookMap.containsKey(bookCopyId)) {
			throw new InvalidBookCopyIdException();
		}
		
		return this.idBookCopyMap.get(bookCopyId);
	}

}
