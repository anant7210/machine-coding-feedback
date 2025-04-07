package com.strategies.equalDivisionStrategy;

import java.util.List;

import com.enums.SplitStrategyType;
import com.strategies.splitObjects.SplitInput;

public class EqualStrategySplitInput extends SplitInput {

	public EqualStrategySplitInput(String paidBy, List<String> participants, double paidAmount) {
		super(paidBy, participants, paidAmount);
	}

	@Override
	public SplitStrategyType getSplitInputType() {
		
		// TODO Auto-generated method stub
		return SplitStrategyType.EQUAL;
	}
	
	

}
