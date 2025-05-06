package com.exceptions;

public class ConsumerNotSubscribedToTopic extends InMemoryQueueException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConsumerNotSubscribedToTopic(String topicId) {
		super(topicId);
		// TODO Auto-generated constructor stub
	}

}
