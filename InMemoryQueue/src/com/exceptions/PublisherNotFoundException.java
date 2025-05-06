package com.exceptions;

public class PublisherNotFoundException extends InMemoryQueueException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PublisherNotFoundException(String publisherId) {
		super(publisherId);
		// TODO Auto-generated constructor stub
	}

}
