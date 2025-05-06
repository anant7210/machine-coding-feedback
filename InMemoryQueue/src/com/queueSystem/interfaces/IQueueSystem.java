package com.queueSystem.interfaces;

import com.exceptions.InMemoryQueueException;

public interface IQueueSystem {
	void initializeQueueSystem() throws InMemoryQueueException;
	
	void addNewConsumer(String consumerId) throws InMemoryQueueException;
	
	void addNewPublisher(String publisherId) throws InMemoryQueueException;
	
	void publishMessage(String producer, String topic, String message) throws InMemoryQueueException;
	
	void addNewTopic(String topicId) throws InMemoryQueueException;
	
	void subscribeConsumerToTopic(String consumerId, String topicId) throws InMemoryQueueException;
}
