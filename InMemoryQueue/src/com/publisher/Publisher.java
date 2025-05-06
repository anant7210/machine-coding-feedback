package com.publisher;

import com.exceptions.InMemoryQueueException;
import com.exceptions.PublisherNotInitialisedException;
import com.publisher.interfaces.IPublisher;
import com.queue.interfaces.IPublishToQueueWrapper;

public class Publisher implements IPublisher {
	
	private IPublishToQueueWrapper queuePublisher;
	
	private String publisherId;
	
	

	public Publisher(String publisherId) {
		this.publisherId = publisherId;
	}

	@Override
	public void publishMessage(String topicId, String message) throws InMemoryQueueException {
		if (queuePublisher == null) {
			throw new PublisherNotInitialisedException(this.publisherId);
		}
		this.queuePublisher.publishToTopic(topicId, message);
	}

	@Override
	public String getPublisherId() throws InMemoryQueueException {
		return this.publisherId;
	}

	@Override
	public void initailizeProducer(IPublishToQueueWrapper publishToQueueWrapper) throws InMemoryQueueException {
		this.queuePublisher = publishToQueueWrapper;
	}

}
