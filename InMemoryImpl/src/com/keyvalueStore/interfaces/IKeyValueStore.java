package com.keyvalueStore.interfaces;

import java.util.List;

import com.attribute.interfaces.IValueAttribute;
import com.commonClasses.Pair;
import com.exceptions.DataFormatIncorrectException;


public interface IKeyValueStore {
	
	IValueAttribute<String, String> get(String key);
	
	List<String> search(String attributeKey, String attributeValue) throws DataFormatIncorrectException;
	
	void put(String key, List<Pair<String, String>> listOfAttributesPair) throws DataFormatIncorrectException;
	
	void delete(String key);
	
	List<String> keys();
}
