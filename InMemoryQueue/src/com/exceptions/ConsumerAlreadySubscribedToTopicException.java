package com.exceptions;

public class ConsumerAlreadySubscribedToTopicException extends InMemoryQueueException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConsumerAlreadySubscribedToTopicException(String topicId) {
		super(topicId);
		// TODO Auto-generated constructor stub
	}

}
