package com.strategies.interfaces;
import com.enums.InputValidationResult;
import com.enums.SplitStrategyType;
import com.strategies.splitObjects.SplitResult;

public interface ISplitStrategy {
	InputValidationResult verifyInput(ISplitInput splitInput);
	SplitResult getFinalSplit(ISplitInput splitInput);
	SplitStrategyType getSpliStrategyType();
}
