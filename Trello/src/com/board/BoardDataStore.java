package com.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.board.interfaces.IBoardAccessDataStore;
import com.board.interfaces.IListAccessDataStore;
import com.common.BoardDetails;
import com.common.ListDetails;
import com.exception.BoardIDAlreadyExists;
import com.exception.BoardNotFoundException;
import com.exception.ListIDAlreadyExistsException;
import com.exception.TrelloException;
import com.idgenerator.interfaces.IIDGenerator;

public class BoardDataStore implements IBoardAccessDataStore {
	
	private IListAccessDataStore listDataStore;
	
	private IIDGenerator idGenerator;
	
	private HashMap<String, BoardDetails> idBoardMap;
	
	

	public BoardDataStore(IListAccessDataStore listDataStore, IIDGenerator idGenerator) {
		this.listDataStore = listDataStore;
		this.idGenerator = idGenerator;
		
		this.idBoardMap = new HashMap<String, BoardDetails>();
	}

	@Override
	public BoardDetails getBoardDetails(String boardId) throws TrelloException {
		if (!this.idBoardMap.containsKey(boardId)) {
			throw new BoardNotFoundException(boardId);
		}
		
		return this.idBoardMap.get(boardId);
	}

	@Override
	public List<BoardDetails> getAllBoardDetails() throws TrelloException {
		Iterator<String> it = this.idBoardMap.keySet().iterator();
		List<BoardDetails> result = new ArrayList<BoardDetails>();
		while (it.hasNext()) {
			result.add(this.idBoardMap.get(it.next()));
		}
		
		return result;
	}

	@Override
	public BoardDetails createBoard(String name) throws TrelloException {
		String boardId = this.idGenerator.generateNextId();
		
		if (this.idBoardMap.containsKey(boardId)) {
			throw new BoardIDAlreadyExists(boardId);
		}
		
		this.idBoardMap.put(boardId, new BoardDetails(name));
		
		return this.idBoardMap.get(boardId);
	}

	@Override
	public boolean updateBoardDetails(BoardDetails boardDetails) throws TrelloException {
		if (!this.idBoardMap.containsKey(boardDetails.getId())) {
			throw new BoardNotFoundException(boardDetails.getId());
		}
		
		this.idBoardMap.get(boardDetails.getId()).updateBoardDetails(boardDetails);
		
		return true;
	}

	@Override
	public boolean deleteBoard(String boardId) throws TrelloException {
		if (!this.idBoardMap.containsKey(boardId)) {
			throw new BoardNotFoundException(boardId);
		}
		
		this.idBoardMap.remove(boardId);
		
		return true;
	}

	@Override
	public boolean addListToBoard(ListDetails listDetails) throws TrelloException {
		String boardIdString = listDetails.getBoardId();
		
		if (!this.idBoardMap.containsKey(boardIdString)) {
			throw new BoardNotFoundException(boardIdString);
		}
		
		try {
			this.listDataStore.createListDetails(listDetails);
		} catch (ListIDAlreadyExistsException e) {
			
		}
		
		this.idBoardMap.get(boardIdString).addList(listDataStore.getListDetails(listDetails.getId()));
		
		return true;
	}

}
