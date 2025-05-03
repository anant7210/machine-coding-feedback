package com.application.interfaces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.book.interfaces.IBookManagementStore;
import com.book.interfaces.IBookStore;
import com.common.BookCopyDetails;
import com.common.BookDetails;
import com.common.BookSearchResult;
import com.common.enums.SearchAttribute;
import com.exception.LibraryManagementException;
import com.libraryManangement.interfaces.ILibraryManagementDataStore;
import com.user.interfaces.IUserActivityDataStore;

public class LibraryManagementSystem implements ILibraryManagementSystem {
	
	private ILibraryManagementDataStore libraryManagementDataStore;
	
	private IBookManagementStore bookManagementStore;
	
	private IBookStore bookStore;
	
	private IUserActivityDataStore userActivityDataStore;
	
	

	public LibraryManagementSystem(ILibraryManagementDataStore libraryManagementDataStore,
			IBookManagementStore bookManagementStore, IBookStore bookStore,
			IUserActivityDataStore userActivityDataStore) {
		this.libraryManagementDataStore = libraryManagementDataStore;
		this.bookManagementStore = bookManagementStore;
		this.bookStore = bookStore;
		this.userActivityDataStore = userActivityDataStore;
	}

	@Override
	public boolean addBook(int bookId, String bookName, List<String> authorList, List<String> publisher,
			List<String> bookCopyIds) throws LibraryManagementException {
		BookDetails bookDetails = this.createBookDetails(bookId, bookName, authorList, publisher, bookCopyIds);
		
		this.bookStore.addBook(bookDetails);
		
		this.addBookCopiesToLibraryManagementStore(this.bookStore.getBookDetails(bookId).getCopies());
		
		return true;
	}

	private void addBookCopiesToLibraryManagementStore(HashSet<BookCopyDetails> copies) throws LibraryManagementException {
		Iterator<BookCopyDetails> it = copies.iterator();
		
		while (it.hasNext()) {
			this.libraryManagementDataStore.addBookCopyToRack(it.next());
		}
		
	}

	private BookDetails createBookDetails(int bookId, String bookName, List<String> authorList, List<String> publisher,
			List<String> bookCopyIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeBookCopy(String bookCopyId) throws LibraryManagementException {
		this.bookStore.removeBookCopy(bookCopyId);
		this.libraryManagementDataStore.removeBookCopyFromRack(bookCopyId);
		
		return true;
	}

	@Override
	public boolean borrowBook(int bookId, String userId, String dueDate) throws LibraryManagementException {
		String bookCopyID = this.bookStore.getBookDetails(bookId).getNextAvailableBookCopy();
		
		
		return this.borrowBookCopy(bookCopyID, userId, dueDate);
	}

	@Override
	public boolean borrowBookCopy(String bookCopyId, String userId, String dueDate) throws LibraryManagementException {
		if (this.userActivityDataStore.canBorrowBook(userId)) {
			return false;
		}
		
		if (this.bookManagementStore.canBorrowBookCopy(bookCopyId)) {
			return false;
		}
		
		this.bookManagementStore.borrowBookCopy(bookCopyId);
		this.userActivityDataStore.updateBorrowedBookDetails(userId, bookCopyId);
		
		return true;
	}

	@Override
	public boolean returnBookCopy(String bookCopyId) throws LibraryManagementException {
		this.bookManagementStore.returnBook(bookCopyId);
		this.userActivityDataStore.returnBookCopy(bookCopyId);
		
		return true;
	}

	@Override
	public List printBorrowedBook(String userId) throws LibraryManagementException {
		return new ArrayList<String>(this.userActivityDataStore.getBorrowedBooks(userId));
	}

	@Override
	public BookSearchResult search(SearchAttribute attribute, String value) throws LibraryManagementException {
		List<BookCopyDetails> bookCopyDetails = this.bookManagementStore.search(attribute, value);
		
		return this.createBookSearchResult(bookCopyDetails);
	}

	private BookSearchResult createBookSearchResult(List<BookCopyDetails> bookCopyDetails) {
		return new BookSearchResult(bookCopyDetails);
	}
	
	

}
