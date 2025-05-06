package com.queueSystem;

import java.util.HashMap;
import java.util.Map;

import com.consumer.interfaces.IConsumer;
import com.consumer.interfaces.IConsumerFactory;
import com.exceptions.InMemoryQueueException;
import com.exceptions.PublisherNotFoundException;
import com.publisher.interfaces.IPublisher;
import com.publisher.interfaces.IPublisherfactory;
import com.queue.interfaces.IQueueWrapper;
import com.queueSystem.interfaces.IQueueSystem;

public class QueueSystem implements IQueueSystem {
	
	private IQueueWrapper queueWrapper;
	
	private Map<String, IPublisher> publisherMap;
	
	private Map<String, IConsumer> consumerMap;
	
	private IPublisherfactory publisherfactory;
	
	private IConsumerFactory consumerFactory;
	
	
	

	public QueueSystem(IQueueWrapper queueWrapper, IPublisherfactory publisherfactory,
			IConsumerFactory consumerFactory) {
		this.queueWrapper = queueWrapper;
		this.publisherfactory = publisherfactory;
		this.consumerFactory = consumerFactory;
		this.publisherMap = new HashMap<String, IPublisher>();
		this.consumerMap = new HashMap<String, IConsumer>();
	}

	@Override
	public void initializeQueueSystem() throws InMemoryQueueException {
		

	}

	@Override
	public void addNewConsumer(String consumerId) throws InMemoryQueueException {
		if (this.consumerMap.containsKey(consumerId)) {
			throw new ConsumerAlreadyExistsException(consumerId);
		}
		
		IConsumer consumer = this.consumerFactory.createConsumer(consumerId);
		
		this.consumerMap.put(consumerId, consumer);
		
		consumer.initialiseConsumer(queueWrapper);
	}

	@Override
	public void addNewPublisher(String publisherId) throws InMemoryQueueException {
		if (this.publisherMap.containsKey(publisherId)) {
			throw new PublisherAlreadyExists(publisherId);
		}
		
		IPublisher publisher = publisherfactory.createPublisher(publisherId);
		
		this.publisherMap.put(publisherId, publisher);
		
		publisher.initailizeProducer(queueWrapper);
	}

	@Override
	public void publishMessage(String producer, String topic, String message) throws InMemoryQueueException {
		if (!this.publisherMap.containsKey(producer)) {
			throw new PublisherNotFoundException(producer);
		}
		
		this.publisherMap.get(producer).publishMessage(topic, message);
	}

	@Override
	public void addNewTopic(String topicId) throws InMemoryQueueException {
		queueWrapper.addQueueForTopic(topicId);
	}

	@Override
	public void subscribeConsumerToTopic(String consumerId, String topicId) throws InMemoryQueueException {
		if (!this.consumerMap.containsKey(consumerId)) {
			throw new ConsumerNotFoundException(consumerId);
		}
		
		this.consumerMap.get(consumerId).subscribeToTopic(topicId);
	}

}
