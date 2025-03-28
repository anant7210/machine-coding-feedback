package com.factory;

import com.dataStore.UserDataStore;
import com.dataStore.UserPairOwedAmountDataStore;
import com.dataStore.interfaces.IUserDataStore;
import com.dataStore.interfaces.IUserPairOwedAmountDataStore;
import com.factory.interfaces.IDataStoreFactory;

public class DataStoreFactory implements IDataStoreFactory {
	private IUserDataStore userDataStore;
	
	private IUserPairOwedAmountDataStore userPairOwedAmountDataStore;
	@Override
	public IUserDataStore getUserDataStore() {
		if (userDataStore == null) {
			this.userDataStore = new UserDataStore();
		}
		return this.userDataStore;
	}

	@Override
	public IUserPairOwedAmountDataStore getUserPairOwedAmountDataStore() {
		if (userPairOwedAmountDataStore == null) {
			this.userPairOwedAmountDataStore = new UserPairOwedAmountDataStore();
		}
		
		return this.userPairOwedAmountDataStore;
	}
	
}
