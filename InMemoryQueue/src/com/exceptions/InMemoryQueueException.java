package com.exceptions;

public class InMemoryQueueException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public InMemoryQueueException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
	
	
}
