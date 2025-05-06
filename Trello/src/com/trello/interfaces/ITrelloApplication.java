package com.trello.interfaces;

import java.util.List;

import com.common.BoardDetails;
import com.common.CardDetails;
import com.common.ListDetails;
import com.common.enums.Privacy;
import com.exception.TrelloException;

public interface ITrelloApplication {
	String createBoard(String boardName) throws TrelloException;
	
	boolean updateName(String boardId, String name) throws TrelloException;
	
	boolean updatePrivacy(String boardId, Privacy privacy) throws TrelloException;
	
	boolean addMember(String boardId, String userId) throws TrelloException;
	
	boolean removeMember(String boardId, String userId) throws TrelloException;
	
	BoardDetails showBoardDetails(String boardId) throws TrelloException;
	
	List<BoardDetails> showAllBoards() throws TrelloException;
	
	boolean deleteBoard(String boardId) throws TrelloException;
	
	boolean createList(String boardId, String listName) throws TrelloException;
	
	ListDetails showListDetails(String listId) throws TrelloException;
	
	boolean deleteList(String listId) throws TrelloException;
	
	String createCard(String listId, String userEmail) throws TrelloException;
	
	boolean assignCardTo(String cardId, String userEmail) throws TrelloException;
	
	boolean updateCardName(String cardId, String name) throws TrelloException;
	
	boolean updateCardDescription(String cardId, String description) throws TrelloException;
	
	boolean unassignUserFromCard(String cardId, String userEmail) throws TrelloException;
	
	boolean deleteCard(String cardId) throws TrelloException;
	
	boolean movCardToList(String cardId, String listId) throws TrelloException;
	
	CardDetails getCardDetails(String cardId) throws TrelloException;
	
}
