package com.queueSystem;

import com.exceptions.InMemoryQueueException;

public class ConsumerNotFoundException extends InMemoryQueueException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConsumerNotFoundException(String consumerId) {
		super(consumerId);
		// TODO Auto-generated constructor stub
	}

}
