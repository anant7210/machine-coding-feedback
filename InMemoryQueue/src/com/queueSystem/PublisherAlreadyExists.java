package com.queueSystem;

import com.exceptions.InMemoryQueueException;

public class PublisherAlreadyExists extends InMemoryQueueException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PublisherAlreadyExists(String publisherId) {
		super(publisherId);
		// TODO Auto-generated constructor stub
	}

}
