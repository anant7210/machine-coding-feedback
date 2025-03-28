package com.dataStore.interfaces;

import com.strategies.splitObjects.SplitResult;

public interface IUserPairOwedAmountDataStore {
	boolean updateAmount(String userId1, String userId2, double amount);
	
	SplitResult getBalancesForUser(String userId);
	
	SplitResult getBalancesForAllUsers();
	
	boolean updateAmountForEntries(SplitResult splitResult);
}
