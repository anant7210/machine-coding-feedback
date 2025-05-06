package com.queueSystem;

import com.exceptions.InMemoryQueueException;

public class ConsumerAlreadyExistsException extends InMemoryQueueException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConsumerAlreadyExistsException(String consumerId) {
		super(consumerId);
		// TODO Auto-generated constructor stub
	}

}
