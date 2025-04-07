package com.exactDivisionStrategy;

import java.util.HashMap;
import java.util.List;
import com.interfaces.ISplitInput;
import com.splitObjects.SplitInput;
import com.splitObjects.StrategyInputGenerator;

public class ExactStartegyInputGenerator extends StrategyInputGenerator {
	@Override
	public ExactStrategySplitInput generateSplitInput(ISplitInput baseInput, List<String> input, int lastVisitedIndex) {
		SplitInput baseInput2 = super.generateSplitInput(baseInput, input, lastVisitedIndex);
		
		int i = lastVisitedIndex;
		i++;
		HashMap<String, Double> amountOwedMap = new HashMap<String, Double>();
		
		int count = 0;
		
		while (count < baseInput2.getParticipants().size()) {
			
			if (i < input.size()) {
				amountOwedMap.put(baseInput2.getParticipants().get(count), Double.parseDouble(input.get(i)));
				i++;
			} else {
				amountOwedMap.put(baseInput2.getParticipants().get(count), 0.0);
			}
			
			count++;
		}
		return new ExactStrategySplitInput(baseInput2.getPaidBy(), baseInput2.getParticipants(), baseInput2.getPaidAmount(), amountOwedMap);
		
	}
}
