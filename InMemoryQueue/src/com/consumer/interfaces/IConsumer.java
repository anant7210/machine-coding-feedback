package com.consumer.interfaces;

import com.exceptions.InMemoryQueueException;
import com.queue.interfaces.IConsumeFromQueue;

public interface IConsumer {
	
	void initialiseConsumer(IConsumeFromQueue consumeFromQueue) throws InMemoryQueueException;
	
	String getConsumerId() throws InMemoryQueueException;
	
	void subscribeToTopic(String topicId) throws InMemoryQueueException;
	
	void removeTopicSubscription(String topicId) throws InMemoryQueueException;
	
}
