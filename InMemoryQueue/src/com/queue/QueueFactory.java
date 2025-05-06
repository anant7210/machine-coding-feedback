package com.queue;

import com.exceptions.InMemoryQueueException;
import com.queue.interfaces.IQueue;
import com.queue.interfaces.IQueueFactory;

public class QueueFactory implements IQueueFactory {

	@Override
	public IQueue createNewQueue(String topicId) throws InMemoryQueueException {
		return new QueueImpl(topicId);
	}

}
