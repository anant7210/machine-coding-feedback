package com.board.interfaces;

import com.common.CardDetails;
import com.exception.TrelloException;

public interface ICardAccessDataStore {
	CardDetails getCardDetails(String cardId) throws TrelloException;
	
	CardDetails createCard(String name) throws TrelloException;
	
	boolean deleteCard(String cardid) throws TrelloException;
	
	CardDetails updateCardDetails(CardDetails cardDetails) throws TrelloException;
}
