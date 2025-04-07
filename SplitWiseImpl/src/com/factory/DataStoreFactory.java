package com.factory;

import com.dataStore.UserDataStore;
import com.dataStore.UserPairOwedAmountDataStore;
import com.interfaces.IDataStoreFactory;
import com.interfaces.IUserDataStore;
import com.interfaces.IUserPairOwedAmountDataStore;

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
