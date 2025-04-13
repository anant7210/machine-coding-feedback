package com.keyvalueStore;

import java.util.List;

import com.attribute.ValueAttribute;
import com.attribute.interfaces.IValueAttribute;
import com.commonClasses.Pair;
import com.exceptions.DataFormatIncorrectException;
import com.keyvalueStore.interfaces.IKeyValueStore;
import com.map.interfaces.IKeyValueMap;

public class KeyValueStore implements IKeyValueStore {
	
	private IKeyValueMap keyValueMap;
	
	

	public KeyValueStore(IKeyValueMap keyValueMap) {
		this.keyValueMap = keyValueMap;
	}

	@Override
	public IValueAttribute<String, String> get(String key) {
		return this.keyValueMap.get(key);
	}

	@Override
	public List<String> search(String attributeKey, String attributeValue) throws DataFormatIncorrectException {
		// TODO Auto-generated method stub
		return this.keyValueMap.getKeyContainingAttributeKeyValuePair(attributeKey, attributeValue);
	}

	@Override
	public void put(String key, List<Pair<String, String>> listOfAttributesPair) throws DataFormatIncorrectException {
		this.keyValueMap.put(key, new ValueAttribute(listOfAttributesPair));
	}

	@Override
	public void delete(String key) {
		this.keyValueMap.deleteKey(key);

	}

	@Override
	public List<String> keys() {
		return this.keyValueMap.getKeys();
	}


}
