package com.board;

import java.util.HashMap;

import com.board.interfaces.ICardAccessDataStore;
import com.board.interfaces.IListAccessDataStore;
import com.board.manipulation.interfaces.IListManipulation;
import com.common.CardDetails;
import com.common.ListDetails;
import com.exception.ListNotFoundException;
import com.exception.TrelloException;
import com.idgenerator.interfaces.IIDGenerator;

public class ListManipulationAndDataStore implements IListAccessDataStore, IListManipulation {
	
	private ICardAccessDataStore cardDataStore;
	
	private IIDGenerator idGenerator;
	
	private HashMap<String, ListDetails> idListMap;
	
	

	public ListManipulationAndDataStore(ICardAccessDataStore cardDataStore, IIDGenerator idGenerator) {
		this.cardDataStore = cardDataStore;
		this.idGenerator = idGenerator;
		
		this.idListMap = new HashMap<String, ListDetails>();
	}

	@Override
	public ListDetails changeNameTo(String listId, String name) throws TrelloException {
		if (!idListMap.containsKey(listId)) {
			throw new ListNotFoundException(listId);
		}
		
		this.idListMap.get(listId).setName(name);
		
		return ListDetails.createCopyOf(this.idListMap.get(listId));
		
	}

	@Override
	public ListDetails addCardDetails(String listId, CardDetails cardDetails) throws TrelloException {
		if (!this.idListMap.containsKey(listId)) {
			throw new ListNotFoundException(listId);
		}
		
		
		try {
			this.cardDataStore.createCard(cardDetails.getName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.idListMap.get(listId).addCardToList(this.cardDataStore.getCardDetails(cardDetails.getId()));
		
		return ListDetails.createCopyOf(this.idListMap.get(cardDetails.getId()));
	}

	@Override
	public ListDetails getListDetails(String listId) throws TrelloException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListDetails createListDetails(ListDetails listDetails) throws TrelloException {
		if (!this.idListMap.containsKey(listDetails.getId())) {
			throw new ListNotFoundException(listDetails.getId());
		}
		
		this.idListMap.put(listDetails.getId(), ListDetails.createCopyOf(listDetails));
		
		return this.idListMap.get(listDetails.getId());
	}

	@Override
	public boolean deleteList(String listId) throws TrelloException {
		if (!this.idListMap.containsKey(listId)) {
			throw new ListNotFoundException(listId);
		}
		
		this.idListMap.remove(listId);
		
		return true;
	}

	@Override
	public ListDetails updateListDetails(ListDetails listDetails) throws TrelloException {
		if (!this.idListMap.containsKey(listDetails.getId())) {
			throw new ListNotFoundException(listDetails.getId());
		}
		
		this.idListMap.get(listDetails.getId()).updateListDetails(listDetails);
		
		return this.idListMap.get(listDetails.getId());
	}

}
