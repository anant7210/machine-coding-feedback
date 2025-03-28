package com.exactDivisionStrategy;

import java.util.HashMap;
import java.util.Iterator;

import com.enums.InputValidationResult;
import com.enums.SplitStrategyType;
import com.interfaces.ISplitInput;
import com.interfaces.ISplitStrategy;
import com.splitObjects.SplitResult;

public class ExactDivisionSplitStrategy implements ISplitStrategy {

	@Override
	public InputValidationResult verifyInput(ISplitInput splitInput) {
		ExactStrategySplitInput input;
		
		try {
			input = (ExactStrategySplitInput) splitInput;
			
			double sum = 0.0;
			
			Iterator<String> it = input.getExactAmountOwedMap().keySet().iterator();
			
			while (it.hasNext()) {
				sum += input.getExactAmountOwedMap().get(it.next());
			}
			
			double diff = sum - input.getPaidAmount();
			
			if (diff < 0) {
				diff *= -1.0;
			}
			
			if (diff > 0.01) {
				return InputValidationResult.SUM_NOT_EQUAL_TO_TOTAL_PAID;
			}
			
			return InputValidationResult.VALID;
		} catch (Exception e) {
			return InputValidationResult.WRONG_INPUT_FORMAT;
		}
	}

	@Override
	public SplitResult getFinalSplit(ISplitInput splitInput) {
		if (this.verifyInput(splitInput) != InputValidationResult.VALID) {
			return null;
		}
		
		ExactStrategySplitInput input = (ExactStrategySplitInput) splitInput;
		
		HashMap<String, HashMap<String, Double>> owedByMap = new HashMap<String, HashMap<String, Double>>();
		HashMap<String, HashMap<String, Double>> owedToMap = new HashMap<String, HashMap<String, Double>>();
		HashMap<String, Double> owedMap = new HashMap<String, Double>();
		HashMap<String, Double> owesMap = new HashMap<String, Double>();
		
		owedByMap.put(input.getPaidBy(), new HashMap<String, Double>());
		
		Iterator<String> it = input.getExactAmountOwedMap().keySet().iterator();
		
		double sum = 0.0;
		
		while (it.hasNext()) {
			String next = it.next();
			
			if (owedByMap.containsKey(next)) {
				continue;
			}
			
			owedByMap.get(input.getPaidBy()).put(next, input.getExactAmountOwedMap().get(next));
			
			if (!owedToMap.containsKey(next)) {
				owedToMap.put(next, new HashMap<String, Double>());
			}
			
			owedToMap.get(next).put(input.getPaidBy(), input.getExactAmountOwedMap().get(next));
			
			owesMap.put(next, input.getExactAmountOwedMap().get(next));
			
			sum += input.getExactAmountOwedMap().get(next);
		}
		
		owedMap.put(input.getPaidBy(), sum);
		
		return new SplitResult(owedByMap, owedToMap, owedMap, owesMap);
	}

	@Override
	public SplitStrategyType getSpliStrategyType() {
		// TODO Auto-generated method stub
		return SplitStrategyType.EXACT;
	}

}
