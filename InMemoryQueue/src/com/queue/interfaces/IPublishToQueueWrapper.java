package com.queue.interfaces;

import com.exceptions.InMemoryQueueException;

public interface IPublishToQueueWrapper {
	void publishToTopic(String topic, String message) throws InMemoryQueueException;
}
