package com.percentDivisionStrategy;

import java.util.HashMap;
import java.util.List;
import com.interfaces.ISplitInput;
import com.splitObjects.SplitInput;
import com.splitObjects.StrategyInputGenerator;

public class PercentDivisionInputGenerator extends StrategyInputGenerator {
	@Override
	public PercentDivisionSplitInput generateSplitInput(ISplitInput baseInput, List<String> input, int lastVisitedIndex) {
		SplitInput baseInput2 = super.generateSplitInput(baseInput, input, lastVisitedIndex);
		
		int i = lastVisitedIndex;
		i++;
		HashMap<String, Double> percentOwedMap = new HashMap<String, Double>();
		
		int count = 0;
		
		while (count < baseInput2.getParticipants().size()) {
			
			if (i < input.size()) {
				percentOwedMap.put(baseInput2.getParticipants().get(count), Double.parseDouble(input.get(i)));
				i++;
			} else {
				percentOwedMap.put(baseInput2.getParticipants().get(count), 0.0);
			}
			
			count++;
		}
		return new PercentDivisionSplitInput(baseInput2.getPaidBy(), baseInput2.getParticipants(), baseInput2.getPaidAmount(), percentOwedMap);
		
	}
}
