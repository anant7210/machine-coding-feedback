package com.queue;

import java.util.Map;

import com.common.MessageWrapper;
import com.exceptions.InMemoryQueueException;
import com.exceptions.TopicAlreadyExistsException;
import com.exceptions.TopicDoesNotExistsException;
import com.message.interfaces.IMessagefactory;
import com.queue.interfaces.IQueue;
import com.queue.interfaces.IQueueFactory;
import com.queue.interfaces.IQueueWrapper;

public class QueueWrapper implements IQueueWrapper {
	
	private Map<String, IQueue> topicQueueMap;
	
	private IQueueFactory queueFactory;
	
	private IMessagefactory messageFactory;

	@Override
	public void addQueueForTopic(String topicId) throws InMemoryQueueException {
		if (this.topicQueueMap.containsKey(topicId)) {
			throw new TopicAlreadyExistsException(topicId);
		}
		
		this.topicQueueMap.put(topicId, queueFactory.createNewQueue(topicId));

	}

	@Override
	public void removeTopic(String topicId) throws InMemoryQueueException {
		if (!this.topicQueueMap.containsKey(topicId)) {
			throw new TopicDoesNotExistsException(topicId);
		}
		
		this.topicQueueMap.remove(topicId);
	}

	@Override
	public void publishToTopic(String topic, String message) throws InMemoryQueueException {
		if (!this.topicQueueMap.containsKey(topic)) {
			throw new TopicDoesNotExistsException(topic);
		}
		
		this.topicQueueMap.get(topic).addNewMessage(this.messageFactory.createMessageWrapper(message));

	}

	@Override
	public MessageWrapper getNextMessageForTopic(String topicId) throws InMemoryQueueException {
		if (!this.topicQueueMap.containsKey(topicId)) {
			throw new TopicDoesNotExistsException(topicId);
		}
		
		return this.topicQueueMap.get(topicId).pollNextmessage();
	}

}
