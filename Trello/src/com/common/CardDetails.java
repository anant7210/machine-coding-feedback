package com.common;

import com.exception.NotAssignedToAnyoneException;
import com.exception.TrelloException;

public class CardDetails {
	
	private static String DEFAULT_DESCRIPTION = "Default Description";
	
	
	
	private String id;
	
	private String name;
	
	private String assignedTo;
	
	private String description;
	
	private boolean isAssigned;

	
	public CardDetails(String id, String name) {
		this(id, name, CardDetails.DEFAULT_DESCRIPTION);
	}
	
	

	public CardDetails(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}



	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAssignedTo() {
		return assignedTo;
	}
	
	public void assignTo(String name) {
		this.name = name;
		this.isAssigned = true;
	}
	
	public void unassign() throws TrelloException {
		if (!this.isAssigned) {
			throw new NotAssignedToAnyoneException();
		}
		
		this.assignedTo = "";
		
		this.isAssigned = false;
	}
	
	public void updateCardDetails(CardDetails cardDetails) {
		
	}



	public static CardDetails createCopyOf(CardDetails cardDetails) {
		// TODO Auto-generated method stub
		return null;
	}

}
