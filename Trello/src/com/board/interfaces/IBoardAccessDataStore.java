package com.board.interfaces;

import java.util.List;

import com.common.BoardDetails;
import com.common.ListDetails;
import com.exception.TrelloException;

public interface IBoardAccessDataStore {
	BoardDetails getBoardDetails(String boardId) throws TrelloException;
	
	List<BoardDetails> getAllBoardDetails() throws TrelloException;
	
	BoardDetails createBoard(String name) throws TrelloException;
	
	boolean updateBoardDetails(BoardDetails boardDetails) throws TrelloException;
	
	boolean deleteBoard(String boardId) throws TrelloException;
	
	boolean addListToBoard(ListDetails listDetails) throws TrelloException;
}
