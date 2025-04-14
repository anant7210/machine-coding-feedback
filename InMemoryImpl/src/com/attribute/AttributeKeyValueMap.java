package com.attribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.attribute.interfaces.IAttributeKeyValueMap;
import com.exceptions.DataFormatIncorrectException;

public abstract class AttributeKeyValueMap<T extends Object, Key extends Object, Value extends Object> implements IAttributeKeyValueMap<Key, Value>
{
	
	private HashMap<Key, T> keyValueMap;
	
	private HashMap<T, HashSet<Key>> valueKeyMap;
	
	private HashMap<T, Value> tValueMap;
	
	

	public AttributeKeyValueMap() {
		this.keyValueMap = new HashMap<>();
		this.valueKeyMap = new HashMap<T, HashSet<Key>>();
		this.tValueMap = new HashMap<T, Value>();
	}
	
	protected abstract T getValueAsT(Value value) throws DataFormatIncorrectException;
	
	@Override
	public abstract boolean isValidType(Value value);

	@Override
	public Value get(Key key) {
		if (!keyValueMap.containsKey(key)) {
			
		}
		return this.getValue(this.keyValueMap.get(key));
	}

	@Override
	public void put(Key key, Value value) throws DataFormatIncorrectException {
		if (!isValidType(value)) {
			throw new DataFormatIncorrectException();
		}
		
		if (this.keyValueMap.containsKey(key)) {
			this.valueKeyMap.remove(this.keyValueMap.get(key));
		}
		this.keyValueMap.put(key, this.getValueAsT(value));	
		
		if (!this.valueKeyMap.containsKey(this.getValueAsT(value))) {
			this.valueKeyMap.put(this.getValueAsT(value), new HashSet<Key>());
		}
		
		this.valueKeyMap.get(this.getValueAsT(value)).add(key);
		this.tValueMap.put(this.getValueAsT(value), value);
	}

	@Override
	public boolean containsKey(Key key) {
		if (this.keyValueMap.containsKey(key)) {
			return true;
		}
		
		return false;
	}

	

	@Override
	public List<Key> getkeysWithValues(Value value) throws DataFormatIncorrectException {
		
		if (!this.isValidType(value)) {
			return new ArrayList<Key>();
		}
		
		List<Key> result  = new ArrayList<Key>();
		
		if (!this.valueKeyMap.containsKey(this.getValueAsT(value))) {
			return new ArrayList<Key>();
		}
		
		Iterator<Key> it = this.valueKeyMap.get(getValueAsT(value)).iterator();
		
		while (it.hasNext()) {
			result.add(it.next());
		}
		
		return result;
	}
	
	
	
	@Override
	public void deleteKey(Key key) {
		if (!this.keyValueMap.containsKey(key)) {
			return;
		}
		
	}
	
	
	@Override
	public String toString() {
		return "AttributeKeyValueMap [keyValueMap=" + keyValueMap + ", valueKeyMap=" + valueKeyMap + "]";
	}

	protected Value getValue(T obj) {
		return this.tValueMap.get(obj);
	}

}
