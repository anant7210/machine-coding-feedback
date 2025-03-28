package com.strategies.exactDivisionStrategy;

import java.util.HashMap;
import java.util.List;

import com.strategies.interfaces.ISplitInput;
import com.strategies.splitObjects.SplitInput;
import com.strategies.splitObjects.StrategyInputGenerator;

// TODO: Auto-generated Javadoc
/**
 * The Class ExactStartegyInputGenerator.
 */
public class ExactStartegyInputGenerator extends StrategyInputGenerator {
	
	/**
	 * Generate split input.
	 *
	 * @param baseInput the base input
	 * @param input the input
	 * @param lastVisitedIndex the last visited index
	 * @return the exact strategy split input
	 */
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
