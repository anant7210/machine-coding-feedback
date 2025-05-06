package com.publisher.interfaces;

import com.exceptions.InMemoryQueueException;

public interface IPublisherfactory {
	IPublisher createPublisher(String publisherId) throws InMemoryQueueException;
}
