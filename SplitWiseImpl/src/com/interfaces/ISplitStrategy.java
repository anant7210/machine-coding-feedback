package com.interfaces;
import com.enums.InputValidationResult;
import com.enums.SplitStrategyType;
import com.splitObjects.SplitResult;

public interface ISplitStrategy {
	InputValidationResult verifyInput(ISplitInput splitInput);
	SplitResult getFinalSplit(ISplitInput splitInput);
	SplitStrategyType getSpliStrategyType();
}
