package com.consumer;

import com.common.MessageWrapper;
import com.consumer.interfaces.IConsumerThread;
import com.consumer.interfaces.IUpdateData;
import com.exceptions.InMemoryQueueException;
import com.exceptions.NoMessageAvailableInQueueForTopicException;

public class ConsumerThread implements IConsumerThread {
	
	private IUpdateData updateData;
	
	private String topicId;
	
	private volatile boolean shouldBerunning;
	
	
	

	public ConsumerThread(IUpdateData updateData, String topicId) {
		super();
		this.updateData = updateData;
		this.topicId = topicId;
	}

	@Override
	public void run() {
		this.shouldBerunning = true;
		while (this.shouldBerunning) {
			try {
				MessageWrapper messageWrapper =  this.updateData.getConsumeFromQueue().getNextMessageForTopic(this.topicId);
				this.updateData.addNewMessage(messageWrapper);
				System.out.println(messageWrapper.getMessage());
			} catch (NoMessageAvailableInQueueForTopicException e) {
				try {
					this.wait(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (InMemoryQueueException e) {
				break;
			}
		}
	}

	@Override
	public void stopThread() throws InMemoryQueueException {
		this.shouldBerunning = false;
	}

}
