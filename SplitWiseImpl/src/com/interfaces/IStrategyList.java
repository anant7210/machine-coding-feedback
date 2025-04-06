package com.interfaces;

import java.util.Map;

import com.enums.SplitStrategyType;

public interface IStrategyList {
	Map<SplitStrategyType, ISplitStrategy> getSplitStrategies();
}
