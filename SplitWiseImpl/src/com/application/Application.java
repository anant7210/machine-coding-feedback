package com.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.enums.SplitStrategyType;
import com.interfaces.IApplication;
import com.interfaces.IDataStoreFactory;
import com.interfaces.IInputReader;
import com.interfaces.ISplitInput;
import com.interfaces.IStrategyList;
import com.interfaces.IStrategyListFactory;
import com.interfaces.IUserDataStore;
import com.interfaces.IUserPairOwedAmountDataStore;
import com.splitObjects.SplitResult;

public class Application implements IApplication {
	
	private IUserPairOwedAmountDataStore userPairOwedAmountDataStore;
	
	private IStrategyList strategyList;
	
	private IInputReader inputReader;
	
	
	
	Application(IDataStoreFactory dataStoreFactory, IStrategyListFactory strategyListFactory, List<String> strategiesPresnt, IInputReader inputReader) {

		this.userPairOwedAmountDataStore = dataStoreFactory.getUserPairOwedAmountDataStore();
		
		this.strategyList = strategyListFactory.getStrategyList(strategiesPresnt);
		
		this.inputReader = inputReader;
	}

	@Override
	public boolean addExpense(List<String> expenseInput) {
		ISplitInput splitInput = this.inputReader.parseInput(expenseInput);
		
		if (splitInput == null) {
			return false;
		}
		
		SplitResult splitResult = this.strategyList.getSplitStrategies().get(splitInput.getSplitInputType()).getFinalSplit(splitInput);
		
		return this.userPairOwedAmountDataStore.updateAmountForEntries(splitResult);
	}

	@Override
	public SplitResult getBalanceForUser(String userId) {
		
		return this.getBalanceForUser(userId);
	}

	@Override
	public SplitResult getAllBalances() {
		// TODO Auto-generated method stub
		return this.userPairOwedAmountDataStore.getBalancesForAllUsers();
	}

	@Override
	public List<SplitStrategyType> getStrategiesName() {
		return new ArrayList<SplitStrategyType>(this.strategyList.getSplitStrategies().keySet());
	}

}
