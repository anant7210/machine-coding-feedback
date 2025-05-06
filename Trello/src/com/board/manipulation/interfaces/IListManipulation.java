package com.board.manipulation.interfaces;

import com.common.CardDetails;
import com.common.ListDetails;
import com.exception.TrelloException;

public interface IListManipulation {
	ListDetails changeNameTo(String listId, String name) throws TrelloException;
	
	ListDetails addCardDetails(String listId, CardDetails cardDetails) throws TrelloException;
	
}
