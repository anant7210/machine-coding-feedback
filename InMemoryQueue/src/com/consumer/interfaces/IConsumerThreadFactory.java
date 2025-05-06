package com.consumer.interfaces;


public interface IConsumerThreadFactory {
	IConsumerThread createConsumerThread(String topicId, IUpdateData consumer);
}
