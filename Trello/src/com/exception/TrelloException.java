package com.exception;

public abstract class TrelloException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	

	public TrelloException(String message) {
		this.message = message;
	}



	@Override
	public String getMessage() {
		return this.message;
	}
	
	
	
}
