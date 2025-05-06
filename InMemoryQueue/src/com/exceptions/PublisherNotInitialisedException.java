package com.exceptions;

public class PublisherNotInitialisedException extends InMemoryQueueException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PublisherNotInitialisedException(String publisherId) {
		super(publisherId);
		// TODO Auto-generated constructor stub
	}

}
