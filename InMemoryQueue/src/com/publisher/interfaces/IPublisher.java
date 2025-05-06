package com.publisher.interfaces;

import com.exceptions.InMemoryQueueException;
import com.queue.interfaces.IPublishToQueueWrapper;

public interface IPublisher {
	
	void initailizeProducer(IPublishToQueueWrapper publishToQueueWrapper) throws InMemoryQueueException; 
	void publishMessage(String topicId, String message) throws InMemoryQueueException;
	
	String getPublisherId() throws InMemoryQueueException;
}
