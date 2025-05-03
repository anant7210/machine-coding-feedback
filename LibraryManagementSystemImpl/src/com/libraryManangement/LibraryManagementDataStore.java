package com.libraryManangement;

import java.util.HashMap;
import java.util.HashSet;

import com.book.interfaces.IBookStore;
import com.common.BookCopyDetails;
import com.exception.InvalidBookCopyIdException;
import com.exception.LibraryManagementException;
import com.exception.RackIsFullException;
import com.libraryManangement.interfaces.ILibraryManagementDataStore;

public class LibraryManagementDataStore implements ILibraryManagementDataStore {
	
	private IBookStore bookStore;
	
	private HashMap<Integer, HashSet<BookCopyDetails>> rackBookCopyListMap;
	
	private HashMap<String, Integer> lastRackMap;
	
	private int maxNumberOfRacks;
	
	private HashMap<String, Integer> bookCopyRackMap;
	
	
	public LibraryManagementDataStore(IBookStore bookStore, int maxNumberOfRacks) {
		this.bookStore = bookStore;
		this.maxNumberOfRacks = maxNumberOfRacks;
		this.lastRackMap = new HashMap<String, Integer>();
		this.rackBookCopyListMap = new HashMap<Integer, HashSet<BookCopyDetails>>();
		this.bookCopyRackMap = new HashMap<String, Integer>();
	}

	@Override
	public boolean addBookCopyToRack(BookCopyDetails bookCopyDetails) throws LibraryManagementException {
		if (this.lastRackMap.containsKey(bookCopyDetails.getID()) && this.lastRackMap.get(bookCopyDetails.getID()) == this.maxNumberOfRacks) {
			throw new RackIsFullException();
		}
		
		if (!this.lastRackMap.containsKey(bookCopyDetails.getID())) {
			this.lastRackMap.put(bookCopyDetails.getID(), 0);
		}
		
		this.lastRackMap.put(bookCopyDetails.getID(), this.lastRackMap.get(bookCopyDetails.getID()) + 1);
		
		this.rackBookCopyListMap.get(this.lastRackMap.get(bookCopyDetails.getID())).add(bookCopyDetails);
		
		this.bookStore.getBookCopyDetails(bookCopyDetails.getID()).setRack(this.lastRackMap.get(bookCopyDetails.getID()));
		
		this.bookCopyRackMap.put(bookCopyDetails.getID(), this.lastRackMap.get(bookCopyDetails.getID()));
		
		return true;
	}

	@Override
	public boolean removeBookCopyFromRack(String bookCopyID) throws LibraryManagementException {
		if (!this.bookCopyRackMap.containsKey(bookCopyID)) {
			throw new InvalidBookCopyIdException();
		}
		
		this.rackBookCopyListMap.get(this.bookCopyRackMap.get(bookCopyID)).remove(this.bookStore.getBookCopyDetails(bookCopyID));
		
		this.bookCopyRackMap.remove(bookCopyID);
		
		return true;
	}
}
