package com.interfaces;

import java.util.List;

import com.enums.SplitStrategyType;
import com.splitObjects.SplitResult;

public interface IApplication {
	boolean addExpense(List<String> expenseInput);
	
	SplitResult getBalanceForUser(String userId);
	
	SplitResult getAllBalances();
	
	List<SplitStrategyType> getStrategiesName();
}
