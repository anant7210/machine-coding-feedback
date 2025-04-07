package com.strategies.exactDivisionStrategy;

import java.util.HashMap;
import java.util.List;

import com.enums.SplitStrategyType;
import com.strategies.splitObjects.SplitInput;

public class ExactStrategySplitInput extends SplitInput {
	
	private HashMap<String, Double> exactAmountOwedMap;
	
	public ExactStrategySplitInput(String paidBy, List<String> participants, double paidAmount,
			HashMap<String, Double> exactAmountOwedMap) {
		super(paidBy, participants, paidAmount);
		this.exactAmountOwedMap = exactAmountOwedMap;
	}

	public HashMap<String, Double> getExactAmountOwedMap() {
		return exactAmountOwedMap;
	}

	@Override
	public SplitStrategyType getSplitInputType() {
		
		// TODO Auto-generated method stub
		return SplitStrategyType.EXACT;
	}

	
}
