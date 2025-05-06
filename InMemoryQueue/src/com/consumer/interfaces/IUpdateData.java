package com.consumer.interfaces;

import com.common.MessageWrapper;
import com.queue.interfaces.IConsumeFromQueue;

public interface IUpdateData {
	void addNewMessage(MessageWrapper messageWrapper);
	
	IConsumeFromQueue getConsumeFromQueue();
}
