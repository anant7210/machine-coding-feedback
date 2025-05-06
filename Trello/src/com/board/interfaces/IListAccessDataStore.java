package com.board.interfaces;

import com.common.ListDetails;
import com.exception.TrelloException;

public interface IListAccessDataStore {
	ListDetails getListDetails(String listId) throws TrelloException;
	
	ListDetails createListDetails(ListDetails listDetails) throws TrelloException;
	
	boolean deleteList(String listId) throws TrelloException;
	
	ListDetails updateListDetails(ListDetails listDetails) throws TrelloException;
}
