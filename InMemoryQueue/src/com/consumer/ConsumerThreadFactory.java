package com.consumer;

import com.consumer.interfaces.IConsumerThread;
import com.consumer.interfaces.IConsumerThreadFactory;
import com.consumer.interfaces.IUpdateData;

public class ConsumerThreadFactory implements IConsumerThreadFactory {

	@Override
	public IConsumerThread createConsumerThread(String topicId, IUpdateData consumer) {
		// TODO Auto-generated method stub
		return new ConsumerThread(consumer, topicId);
	}

}
