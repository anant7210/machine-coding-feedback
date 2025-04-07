package com.interfaces;

import java.util.Map;

import com.enums.SplitStrategyType;
import com.strategies.interfaces.ISplitStrategy;

public interface IStrategyList {
	Map<SplitStrategyType, ISplitStrategy> getSplitStrategies();
}
