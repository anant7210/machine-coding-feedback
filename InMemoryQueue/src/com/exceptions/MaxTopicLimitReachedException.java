package com.exceptions;

public class MaxTopicLimitReachedException extends InMemoryQueueException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaxTopicLimitReachedException(String consumerid) {
		super(consumerid);
		// TODO Auto-generated constructor stub
	}

}
