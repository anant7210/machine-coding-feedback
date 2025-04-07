package com.strategies.interfaces;

import java.util.List;

public interface IStrategyInputGenerator {
	ISplitInput generateSplitInput(ISplitInput baseInput, List<String> input, int lastVisitedIndex);
}
