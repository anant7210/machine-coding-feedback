package com.message.interfaces;

import com.common.MessageWrapper;
import com.exceptions.InMemoryQueueException;

public interface IMessagefactory {
	MessageWrapper createMessageWrapper(String message) throws InMemoryQueueException;
}
