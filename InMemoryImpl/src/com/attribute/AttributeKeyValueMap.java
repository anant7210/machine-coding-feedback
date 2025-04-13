package com.attribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.attribute.interfaces.IAttributeKeyValueMap;
import com.exceptions.DataFormatIncorrectException;

public abstract class AttributeKeyValueMap<T extends Object> implements IAttributeKeyValueMap {
	
	private HashMap<String, T> keyValueMap;
	
	private HashMap<T, HashSet<String>> valueKeyMap;
	
	

	public AttributeKeyValueMap() {
		this.keyValueMap = new HashMap<>();
		this.valueKeyMap = new HashMap<T, HashSet<String>>();
	}
	
	protected abstract T getValueAsT(String value) throws DataFormatIncorrectException;
	
	@Override
	public abstract boolean isValidType(String value);

	@Override
	public String get(String key) {
		if (!keyValueMap.containsKey(key)) {
			
		}
		return this.getValueAsString(this.keyValueMap.get(key));
	}

	@Override
	public void put(String key, String value) throws DataFormatIncorrectException {
		if (!isValidType(value)) {
			throw new DataFormatIncorrectException();
		}
		this.keyValueMap.put(key, this.getValueAsT(value));	
		
		if (!this.valueKeyMap.containsKey(this.getValueAsT(value))) {
			this.valueKeyMap.put(this.getValueAsT(value), new HashSet<String>());
		}
		
		this.valueKeyMap.get(this.getValueAsT(value)).add(key);

	}

	@Override
	public boolean containsKey(String key) {
		if (this.keyValueMap.containsKey(key)) {
			return true;
		}
		
		return false;
	}

	

	@Override
	public List<String> getkeysWithValues(String value) throws DataFormatIncorrectException {
		
		if (!this.isValidType(value)) {
			return new ArrayList<String>();
		}
		
		List<String> result  = new ArrayList<String>();
		
		if (!this.valueKeyMap.containsKey(this.getValueAsT(value))) {
			return new ArrayList<String>();
		}
		
		Iterator<String> it = this.valueKeyMap.get(getValueAsT(value)).iterator();
		
		while (it.hasNext()) {
			result.add(it.next());
		}
		
		return result;
	}
	
	
	
	@Override
	public void deleteKey(String key) {
		if (!this.keyValueMap.containsKey(key)) {
			return;
		}
		
	}
	
	

	
	@Override
	public String toString() {
		return "AttributeKeyValueMap [keyValueMap=" + keyValueMap + ", valueKeyMap=" + valueKeyMap + "]";
	}

	protected String getValueAsString(T obj) {
		return obj.toString();
	}

}
