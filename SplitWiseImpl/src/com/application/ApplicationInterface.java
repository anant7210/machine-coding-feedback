package com.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dataStore.interfaces.IUserDataStore;
import com.enums.InputCommand;
import com.factory.interfaces.IDataStoreFactory;
import com.factory.interfaces.IStrategyListFactory;
import com.interfaces.IApplication;
import com.interfaces.IApplicationInterface;
import com.ioParser.interfaces.IInputReader;
import com.ioParser.interfaces.IResultFormatter;
import com.strategies.splitObjects.SplitResult;

public class ApplicationInterface implements IApplicationInterface {
	
	private IApplication application;
	
	private IUserDataStore userDataStore;
	
	private IDataStoreFactory dataStoreFactory;
	
	private IStrategyListFactory strategyListFactory;
	
	private IResultFormatter resultFormatter;
	private IInputReader inputReader;
	@Override
	public void instantiateApplication() {
		this.application = new Application(dataStoreFactory, strategyListFactory, null, inputReader);
		
		this.userDataStore = this.dataStoreFactory.getUserDataStore();
	}

	@Override
	public List<String> runInputString(String input) {
		String[] inputArr = input.split(" ");
		
		List<String> inputList = new ArrayList<String>();
		
		int i = 1;
		
		while (i < inputArr.length) {
			inputList.add(inputArr[i]);
			
			i++;
		}
		
		if (InputCommand.EXPENSE == InputCommand.valueOf(inputArr[0])) {
			this.application.addExpense(inputList);
			
			return Arrays.asList("No Expenses");
		}
		
		if (InputCommand.SHOW == InputCommand.valueOf(inputArr[0])) {
			SplitResult splitResult;
			if (inputList.size() == 0) {
				splitResult = this.application.getAllBalances();
			} else {
				splitResult = this.application.getBalanceForUser(inputList.get(0));
			}
			
			return this.resultFormatter.getFormattedResult(splitResult);
			
		}
		
		return new ArrayList<String>();
		
	}
	
	

}
