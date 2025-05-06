package com.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import com.common.enums.Privacy;
import com.exception.ListIDAlreadyExistsException;
import com.exception.TrelloException;

public class BoardDetails {
	
	private String name;
	
	private String id;
	
	private LinkedHashMap<String, ListDetails> listDetailsMap;
	
	private Privacy privacy;

	public BoardDetails(String name) {
		
		this.name = name;
		// Generate ID
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Privacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(Privacy privacy) {
		this.privacy = privacy;
	}

	public String getId() {
		return id;
	}
	
	public void updateBoardDetails(BoardDetails boardDetails) {
		
	}
	
	public void addList(ListDetails listDetails) throws TrelloException{
		if (this.listDetailsMap.containsKey(listDetails.getId())) {
			throw new ListIDAlreadyExistsException();
		}
		
		this.listDetailsMap.put(listDetails.getId(), listDetails);
	}
	
	public List<ListDetails> getListDetailsList() {
		List<ListDetails> listDetailsList = new ArrayList<ListDetails>();
		
		Iterator<String> it = this.listDetailsMap.keySet().iterator();
		
		while (it.hasNext()) {
			String next = it.next();
			
			listDetailsList.add(this.listDetailsMap.get(next));
		}
		
		return listDetailsList;
	}
	

}
