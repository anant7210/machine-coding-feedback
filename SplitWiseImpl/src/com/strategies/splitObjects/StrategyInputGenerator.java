package com.strategies.splitObjects;

import java.util.List;

import com.strategies.interfaces.ISplitInput;
import com.strategies.interfaces.IStrategyInputGenerator;

public abstract class StrategyInputGenerator implements IStrategyInputGenerator {

	@Override
	public SplitInput generateSplitInput(ISplitInput baseInput, List<String> input, int lastVisitedIndex) {
		try {
			return (SplitInput) baseInput;
		} catch (Exception e) {
			return null;
		}
	}

}
