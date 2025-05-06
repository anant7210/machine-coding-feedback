package com.consumer;

import com.consumer.interfaces.IConsumer;
import com.consumer.interfaces.IConsumerFactory;
import com.consumer.interfaces.IConsumerThreadFactory;
import com.exceptions.InMemoryQueueException;

public class ConsumerFactory implements IConsumerFactory {
	
	private IConsumerThreadFactory consumerThreadFactory;

	@Override
	public IConsumer createConsumer(String consumerId) throws InMemoryQueueException {
		return new Consumer(this.consumerThreadFactory, consumerId);
	}

}
