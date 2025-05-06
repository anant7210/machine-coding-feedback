package com.exceptions;

public class NoMessageAvailableInQueueForTopicException extends InMemoryQueueException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoMessageAvailableInQueueForTopicException(String topicId) {
		super(topicId);
		// TODO Auto-generated constructor stub
	}

}
