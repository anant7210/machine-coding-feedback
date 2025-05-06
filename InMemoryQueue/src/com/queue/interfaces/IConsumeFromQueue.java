package com.queue.interfaces;

import com.common.MessageWrapper;
import com.exceptions.InMemoryQueueException;

public interface IConsumeFromQueue {
	MessageWrapper getNextMessageForTopic(String topicId) throws InMemoryQueueException;
}
