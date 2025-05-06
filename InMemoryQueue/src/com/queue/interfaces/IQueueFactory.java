package com.queue.interfaces;

import com.exceptions.InMemoryQueueException;

public interface IQueueFactory {
	IQueue createNewQueue(String topicId) throws InMemoryQueueException;
}
