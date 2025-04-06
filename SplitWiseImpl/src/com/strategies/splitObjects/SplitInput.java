package com.strategies.splitObjects;

import java.util.List;

import com.strategies.interfaces.ISplitInput;

public abstract class SplitInput implements ISplitInput {
	public SplitInput(String paidBy, List<String> participants, double paidAmount) {
		super();
		this.paidBy = paidBy;
		this.participants = participants;
		this.paidAmount = paidAmount;
	}

	private String paidBy;
	
	private List<String> participants;
	
	private double paidAmount;
	
	

	public String getPaidBy() {
		return paidBy;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}

	public List<String> getParticipants() {
		return participants;
	}

	public void setParticipants(List<String> participants) {
		this.participants = participants;
	}
	
	
}
