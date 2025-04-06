package com.factory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.enums.SplitStrategyType;
import com.equalDivisionStrategy.EqualDivisionSplitStrategy;
import com.exactDivisionStrategy.ExactDivisionSplitStrategy;
import com.interfaces.ISplitStrategy;
import com.interfaces.IStrategyList;
import com.interfaces.IStrategyListFactory;
import com.percentDivisionStrategy.PercentDivisionSplitStrategy;

public class StrategyListFactory implements IStrategyListFactory {
	
	public StrategyListFactory() {
		this.strategyMap.put(SplitStrategyType.EXACT, new ExactDivisionSplitStrategy());
		this.strategyMap.put(SplitStrategyType.EQUAL, new EqualDivisionSplitStrategy());
		this.strategyMap.put(SplitStrategyType.PERCENT, new PercentDivisionSplitStrategy());
	}



	private HashMap<SplitStrategyType, ISplitStrategy> strategyMap = new HashMap<SplitStrategyType, ISplitStrategy>();
	
	

	@Override
	public IStrategyList getStrategyList(List<String> strategiesPresent) {
		Map<SplitStrategyType, ISplitStrategy> result = new LinkedHashMap<SplitStrategyType, ISplitStrategy>();
		
		Iterator<String> it = strategiesPresent.listIterator();
		
		while (it.hasNext()) {
			SplitStrategyType next = SplitStrategyType.valueOf(it.next());
			
			if (this.strategyMap.containsKey(next)) {
				result.put(next, this.strategyMap.get(next));
			}
		}
		
		return new IStrategyList() {
			
			@Override
			public Map<SplitStrategyType, ISplitStrategy> getSplitStrategies() {
				// TODO Auto-generated method stub
				return result;
			}
		};
	}

}
