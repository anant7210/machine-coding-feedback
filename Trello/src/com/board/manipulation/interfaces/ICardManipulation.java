package com.board.manipulation.interfaces;

import com.common.CardDetails;
import com.exception.TrelloException;

public interface ICardManipulation {
	
	CardDetails assignCardTo(String cardId, String name) throws TrelloException;
	
	CardDetails unassignCard(String cardId) throws TrelloException;
	
	CardDetails changeNameTo(String cardid, String name) throws TrelloException;
	
	CardDetails changeDescriptionTo(String cardId, String description) throws TrelloException;

}
