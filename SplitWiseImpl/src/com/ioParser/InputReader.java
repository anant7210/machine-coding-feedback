package com.ioParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.enums.SplitStrategyType;
import com.ioParser.interfaces.IInputReader;
import com.strategies.equalDivisionStrategy.EqualStrategyInutGenerator;
import com.strategies.exactDivisionStrategy.ExactStartegyInputGenerator;
import com.strategies.interfaces.ISplitInput;
import com.strategies.interfaces.IStrategyInputGenerator;
import com.strategies.percentDivisionStrategy.PercentDivisionInputGenerator;
import com.strategies.splitObjects.SplitInput;

public class InputReader implements IInputReader {
	
	
	HashMap<SplitStrategyType, IStrategyInputGenerator> strategyInputGeneratorMap;
	
	public InputReader() {
		this.strategyInputGeneratorMap = new HashMap<SplitStrategyType, IStrategyInputGenerator>();
		
		this.strategyInputGeneratorMap.put(SplitStrategyType.EQUAL, new EqualStrategyInutGenerator());
		
		this.strategyInputGeneratorMap.put(SplitStrategyType.EXACT, new ExactStartegyInputGenerator());
		
		this.strategyInputGeneratorMap.put(SplitStrategyType.PERCENT, new PercentDivisionInputGenerator());
	}

	@Override
	public ISplitInput parseInput(List<String> input) {
		
		if (input.size() < 6) {
			return null;
		}
		
		
		
		try {
			String userId = input.get(0);
			
			double amount = Double.parseDouble(input.get(1));
			
			int noOfParticipants = Integer.parseInt(input.get(2));
			
			List<String> participantList = new ArrayList<String>();
			
			int i = 3;
			
			while (i < 3 + noOfParticipants) {
				participantList.add(input.get(i));
				i++;
			}
			
			SplitStrategyType splitStrategyType = SplitStrategyType.valueOf(input.get(i));
			
			
			return this.strategyInputGeneratorMap.get(splitStrategyType).generateSplitInput(new SplitInput(userId, participantList, amount) {
				
				@Override
				public SplitStrategyType getSplitInputType() {
					// TODO Auto-generated method stub
					return splitStrategyType;
				}
			}, input, i);	
			
		} catch (Exception e) {
			return null;
		}
	}

}
