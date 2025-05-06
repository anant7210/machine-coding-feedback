package com.board;

import java.util.HashMap;

import com.board.interfaces.ICardAccessDataStore;
import com.board.manipulation.interfaces.ICardManipulation;
import com.common.CardDetails;
import com.exception.CardIDAlreadyExists;
import com.exception.CardIDDoesNotExist;
import com.exception.CardNotFoundException;
import com.exception.TrelloException;
import com.idgenerator.interfaces.IIDGenerator;

public class CardManipulationAndDataStore implements ICardAccessDataStore, ICardManipulation {
	
	private HashMap<String, CardDetails> idCardMap;
	
	private IIDGenerator idGenerator;
	
	

	public CardManipulationAndDataStore(IIDGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}

	@Override
	public CardDetails assignCardTo(String cardId, String name) throws TrelloException {
		if (!this.idCardMap.containsKey(cardId)) {
			throw new CardNotFoundException(cardId);
		}
		
		this.idCardMap.get(cardId).assignTo(name);
		
		return CardDetails.createCopyOf(this.idCardMap.get(cardId));
	}

	@Override
	public CardDetails unassignCard(String cardId) throws TrelloException {
		if (!this.idCardMap.containsKey(cardId)) {
			throw new CardNotFoundException(cardId);
		}
		
		this.idCardMap.get(cardId).unassign();
		
		return CardDetails.createCopyOf(this.idCardMap.get(cardId));
	}

	@Override
	public CardDetails changeNameTo(String cardId, String name) throws TrelloException {
		if (!this.idCardMap.containsKey(cardId)) {
			throw new CardNotFoundException(cardId);
		}
		
		this.idCardMap.get(cardId).setName(name);
		
		return CardDetails.createCopyOf(this.idCardMap.get(cardId));
	}

	@Override
	public CardDetails changeDescriptionTo(String cardId, String description) throws TrelloException {
		if (!this.idCardMap.containsKey(cardId)) {
			throw new CardNotFoundException(cardId);
		}
		
		this.idCardMap.get(cardId).setDescription(description);
		
		return CardDetails.createCopyOf(this.idCardMap.get(cardId));
	}

	@Override
	public CardDetails getCardDetails(String cardId) throws TrelloException {
		if (!this.idCardMap.containsKey(cardId)) {
			throw new CardNotFoundException(cardId);
		}
		
		return CardDetails.createCopyOf(this.idCardMap.get(cardId));
	}

	@Override
	public CardDetails createCard(String name) throws TrelloException {
		
		String id = this.idGenerator.generateNextId();
		
		if (this.idCardMap.containsKey(id)) {
			throw new CardIDAlreadyExists(id);
		}
		
		CardDetails cardDetails = new CardDetails(id, name);
		
		this.idCardMap.put(id, cardDetails);
		
		return CardDetails.createCopyOf(cardDetails);
	}

	@Override
	public boolean deleteCard(String cardid) throws TrelloException {
		if (!this.idCardMap.containsKey(cardid)) {
			throw new CardIDDoesNotExist(cardid);
		}
		this.idCardMap.remove(cardid);
		
		this.idGenerator.invalidateId(cardid);
		
		return false;
	}

	@Override
	public CardDetails updateCardDetails(CardDetails cardDetails) throws TrelloException {
		if (!this.idCardMap.containsKey(cardDetails.getId())) {
			throw new CardNotFoundException(cardDetails.getId());
		}
		
		this.idCardMap.get(cardDetails.getId()).updateCardDetails(cardDetails);
		
		return CardDetails.createCopyOf(cardDetails);
		
	}

}
