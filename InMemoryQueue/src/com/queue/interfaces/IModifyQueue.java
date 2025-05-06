package com.queue.interfaces;

import com.exceptions.InMemoryQueueException;

public interface IModifyQueue {
	void addQueueForTopic(String topicId) throws InMemoryQueueException;
	
	void removeTopic(String topicId) throws InMemoryQueueException;
}
