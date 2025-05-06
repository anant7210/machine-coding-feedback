package com.queue.interfaces;

import com.common.MessageWrapper;
import com.exceptions.InMemoryQueueException;

public interface IQueue {
	void addNewMessage(MessageWrapper message) throws InMemoryQueueException;
	
	MessageWrapper pollNextmessage() throws InMemoryQueueException;
	
	String getTopic();
}
