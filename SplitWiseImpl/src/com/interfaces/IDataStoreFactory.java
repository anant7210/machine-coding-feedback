package com.interfaces;

public interface IDataStoreFactory {
	IUserDataStore getUserDataStore();
	
	IUserPairOwedAmountDataStore getUserPairOwedAmountDataStore();
}
