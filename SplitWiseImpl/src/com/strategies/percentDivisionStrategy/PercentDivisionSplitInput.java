package com.strategies.percentDivisionStrategy;

import java.util.HashMap;
import java.util.List;

import com.enums.SplitStrategyType;
import com.strategies.splitObjects.SplitInput;

public class PercentDivisionSplitInput extends SplitInput {
	private HashMap<String, Double> percentOwedMap;
	
	public PercentDivisionSplitInput(String paidBy, List<String> participants, double paidAmount,
			HashMap<String, Double> percentOwedMap) {
		super(paidBy, participants, paidAmount);
		this.percentOwedMap = percentOwedMap;
	}

	public HashMap<String, Double> getPercentOwedMap() {
		return percentOwedMap;
	}

	@Override
	public SplitStrategyType getSplitInputType() {
		
		return SplitStrategyType.PERCENT;
	}
}
