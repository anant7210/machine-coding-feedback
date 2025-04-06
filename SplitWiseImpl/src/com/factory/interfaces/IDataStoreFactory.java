package com.factory.interfaces;

import com.dataStore.interfaces.IUserDataStore;
import com.dataStore.interfaces.IUserPairOwedAmountDataStore;

public interface IDataStoreFactory {
	IUserDataStore getUserDataStore();
	
	IUserPairOwedAmountDataStore getUserPairOwedAmountDataStore();
}
