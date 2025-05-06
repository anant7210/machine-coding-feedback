package com.consumer;

import java.util.HashSet;
import java.util.Map;

import com.common.MessageWrapper;
import com.consumer.interfaces.IConsumer;
import com.consumer.interfaces.IConsumerThread;
import com.consumer.interfaces.IConsumerThreadFactory;
import com.consumer.interfaces.IUpdateData;
import com.exceptions.ConsumerAlreadySubscribedToTopicException;
import com.exceptions.ConsumerNotSubscribedToTopic;
import com.exceptions.InMemoryQueueException;
import com.exceptions.MaxTopicLimitReachedException;
import com.queue.interfaces.IConsumeFromQueue;

public class Consumer implements IConsumer, IUpdateData {
	public static int DEFAULT_MAX_THREAD_ALLOWED = 10;
	private IConsumerThreadFactory consumerThreadFactory;
	
	private String consumerid;
	
	private Map<String, IConsumerThread> topicThreadMap;
	
	private int maxThread;
	
	private IConsumeFromQueue consumeFromQueue;
	
	private Map<String, HashSet<String>> topicMessagesMap;
	
	

	public Consumer(IConsumerThreadFactory consumerThreadFactory, String consumerid) {
		this(consumerThreadFactory, consumerid, Consumer.DEFAULT_MAX_THREAD_ALLOWED);
	}
	
	

	public Consumer(IConsumerThreadFactory consumerThreadFactory, String consumerid, int maxThread) {
		super();
		this.consumerThreadFactory = consumerThreadFactory;
		this.consumerid = consumerid;
		this.maxThread = maxThread;
	}



	@Override
	public String getConsumerId() throws InMemoryQueueException {
		return this.consumerid;
	}

	@Override
	public void subscribeToTopic(String topicId) throws InMemoryQueueException {
		if (this.topicThreadMap.containsKey(topicId)) {
			throw new ConsumerAlreadySubscribedToTopicException(topicId);
		}
		
		if (topicThreadMap.size() == this.maxThread) {
			throw new MaxTopicLimitReachedException(this.consumerid);
		}
		IConsumerThread thread = this.consumerThreadFactory.createConsumerThread(topicId, this);
		
		thread.run();
		this.topicThreadMap.put(topicId, thread);
	}

	@Override
	public void removeTopicSubscription(String topicId) throws InMemoryQueueException {
		if (!this.topicThreadMap.containsKey(topicId)) {
			throw new ConsumerNotSubscribedToTopic(topicId);
		}
		
		this.topicThreadMap.get(topicId).stopThread();
		
		this.topicThreadMap.remove(topicId);
	}



	@Override
	public void initialiseConsumer(IConsumeFromQueue consumeFromQueue) throws InMemoryQueueException {
		this.consumeFromQueue = consumeFromQueue;
		
	}



	@Override
	public void addNewMessage(MessageWrapper messageWrapper) {
		this.topicMessagesMap.get(messageWrapper.getTopic()).add(messageWrapper.getMessage());
	}



	@Override
	public IConsumeFromQueue getConsumeFromQueue() {
		return this.consumeFromQueue;
	}


}
