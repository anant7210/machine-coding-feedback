package com.dataStore;

import java.util.HashMap;
import java.util.Iterator;

import com.dataStore.interfaces.IUserPairOwedAmountDataStore;
import com.strategies.splitObjects.SplitResult;

public class UserPairOwedAmountDataStore implements IUserPairOwedAmountDataStore {
	private HashMap<String, HashMap<String, Double>> owedByMap = new HashMap<String, HashMap<String,Double>>();
	private HashMap<String, HashMap<String, Double>> owesToMap = new HashMap<String, HashMap<String,Double>>();


	@Override
	public boolean updateAmount(String userId1, String userId2, double amount) {
		double amountOwed = amount;
		if (this.owedByMap.containsKey(userId2) && this.owedByMap.get(userId2).containsKey(userId1)) {
			amountOwed = amount - owedByMap.get(userId2).get(userId1);
			
			if (amountOwed > 0) {
				this.owedByMap.get(userId2).put(userId1, amountOwed);
				
				this.owesToMap.get(userId1).put(userId2, amountOwed);
				
				return true;
			}
			
			this.owedByMap.get(userId2).remove(userId1);
			this.owesToMap.get(userId1).remove(userId2);
		}
		
		
		
		if (!this.owedByMap.containsKey(userId1)) {
			this.owedByMap.put(userId1, new HashMap<String, Double>());
		}
		
		this.owedByMap.get(userId1).put(userId2, amountOwed);
		
		if (!owesToMap.containsKey(userId2)) {
			this.owesToMap.put(userId2, new HashMap<String, Double>());
		}
		
		this.owesToMap.get(userId2).put(userId1, amountOwed);
			
		return true;
	}

	@Override
	public SplitResult getBalancesForUser(String userId) {
		SplitResult result = new SplitResult();
		
		result.getOwedBy().put(userId, this.owedByMap.get(userId));
		
		result.getOwedTo().put(userId, this.owesToMap.get(userId));
		
		return result;
	}

	@Override
	public SplitResult getBalancesForAllUsers() {
		return new SplitResult(owedByMap, owedByMap, null, null);
	}

	@Override
	public boolean updateAmountForEntries(SplitResult splitResult) {
		Iterator<String> it = splitResult.getOwedBy().keySet().iterator();
		while (it.hasNext()) {
			String next = it.next();
			
			Iterator<String> it1 = splitResult.getOwedBy().get(next).keySet().iterator();
			
			while (it1.hasNext()) {
				String next1 = it1.next();
				
				this.updateAmount(next, next1, splitResult.getOwedBy().get(next).get(next1));
			}
		}
		
		return true;
	}
	
}
