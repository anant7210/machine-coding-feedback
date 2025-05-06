package com.exceptions;

public class TopicDoesNotExistsException extends InMemoryQueueException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TopicDoesNotExistsException(String topicId) {
		super(topicId);
		// TODO Auto-generated constructor stub
	}

}
