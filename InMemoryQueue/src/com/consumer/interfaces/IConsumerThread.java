package com.consumer.interfaces;

import com.exceptions.InMemoryQueueException;

public interface IConsumerThread extends Runnable {
	
	void stopThread() throws InMemoryQueueException;

}
