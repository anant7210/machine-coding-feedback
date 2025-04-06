package com.application;

import java.util.ArrayList;
import java.util.List;

import com.dataStore.interfaces.IUserPairOwedAmountDataStore;
import com.enums.SplitStrategyType;
import com.factory.interfaces.IDataStoreFactory;
import com.factory.interfaces.IStrategyListFactory;
import com.interfaces.IApplication;
import com.interfaces.IStrategyList;
import com.ioParser.interfaces.IInputReader;
import com.strategies.interfaces.ISplitInput;
import com.strategies.splitObjects.SplitResult;

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
