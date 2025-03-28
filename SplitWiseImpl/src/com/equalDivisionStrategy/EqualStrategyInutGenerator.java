package com.equalDivisionStrategy;

import java.util.List;

import com.interfaces.ISplitInput;
import com.splitObjects.SplitInput;
import com.splitObjects.StrategyInputGenerator;

public class EqualStrategyInutGenerator extends StrategyInputGenerator {
	
	@Override
	public EqualStrategySplitInput generateSplitInput(ISplitInput baseInput, List<String> input, int lastVisitedIndex) {
		SplitInput baseInput2 = super.generateSplitInput(baseInput, input, lastVisitedIndex);
		
		return new EqualStrategySplitInput(baseInput2.getPaidBy(), baseInput2.getParticipants(), baseInput2.getPaidAmount());
	}
}
