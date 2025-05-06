package com.publisher;

import com.exceptions.InMemoryQueueException;
import com.publisher.interfaces.IPublisher;
import com.publisher.interfaces.IPublisherfactory;

public class PublisherFactory implements IPublisherfactory {

	@Override
	public IPublisher createPublisher(String publisherId) throws InMemoryQueueException {
		return new Publisher(publisherId);
	}

}
