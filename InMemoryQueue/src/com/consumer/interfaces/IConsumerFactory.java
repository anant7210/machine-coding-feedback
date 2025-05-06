package com.consumer.interfaces;

import com.exceptions.InMemoryQueueException;

public interface IConsumerFactory {
	IConsumer createConsumer(String consumerId) throws InMemoryQueueException;
}
