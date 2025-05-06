package com.exceptions;

public class TopicAlreadyExistsException extends InMemoryQueueException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TopicAlreadyExistsException(String topicId) {
		super(topicId);
		// TODO Auto-generated constructor stub
	}

}
