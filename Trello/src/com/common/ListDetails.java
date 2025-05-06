package com.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import com.exception.CardIDAlreadyExistsException;
import com.exception.TrelloException;

public class ListDetails {
	
	private String id;
	
	private String name;
	
	private String boardId;
	
	private LinkedHashMap<String, CardDetails> cardDetailsMap;
	
	
	
	public ListDetails(String name, String boardId) {
		this.name = name;
		this.boardId = boardId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBoardId() {
		return boardId;
	}



	public String getId() {
		// TODO Auto-generated method stub
		
		
		return this.id;
	}
	
	public void addCardToList(CardDetails cardDetails) throws TrelloException {
		if (this.cardDetailsMap.containsKey(cardDetails.getId())) {
			throw new CardIDAlreadyExistsException();
		}
		
		this.cardDetailsMap.put(cardDetails.getId(), cardDetails);
	}
	
	public List<CardDetails> getCardList() {
		List<CardDetails> cardList = new ArrayList<CardDetails>();
		
		Iterator<String> it = this.cardDetailsMap.keySet().iterator();
		
		while (it.hasNext()) {
			String next = it.next();
			
			cardList.add(this.cardDetailsMap.get(next));
		}
		
		return cardList;
	}



	public static ListDetails createCopyOf(ListDetails listDetails) {
		// TODO Auto-generated method stub
		return null;
	}



	public void updateListDetails(ListDetails listDetails) {
		// TODO Auto-generated method stub
		
	}

}
