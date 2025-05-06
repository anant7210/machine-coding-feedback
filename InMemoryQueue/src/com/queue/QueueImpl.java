package com.queue;

import java.util.Queue;

import com.common.MessageWrapper;
import com.exceptions.InMemoryQueueException;
import com.exceptions.NoMessageAvailableInQueueForTopicException;
import com.queue.interfaces.IQueue;

public class QueueImpl implements IQueue {
	
	private String topic;
	
	private Queue<MessageWrapper> messageQueue;
	
	
	
	public QueueImpl(String topic) {
		this.topic = topic;
	}

	@Override
	public void addNewMessage(MessageWrapper message) throws InMemoryQueueException {
		this.messageQueue.add(message);
	}

	@Override
	public MessageWrapper pollNextmessage() throws InMemoryQueueException {
		if (this.messageQueue.size() == 0) {
			throw new NoMessageAvailableInQueueForTopicException(this.topic);
		}
		
		return this.messageQueue.poll();
	}

	@Override
	public String getTopic() {
		return this.topic;
	}

}
