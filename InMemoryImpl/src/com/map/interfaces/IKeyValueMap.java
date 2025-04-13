package com.map.interfaces;

import java.util.List;

import com.attribute.interfaces.IValueAttribute;
import com.exceptions.DataFormatIncorrectException;

public interface IKeyValueMap {
	IValueAttribute<String, String> get(String key);
	
	void put(String key, IValueAttribute<String, String> value) throws DataFormatIncorrectException;
	
	List<String> getKeyContainingAttributeKeyValuePair(String attribute, String value) throws DataFormatIncorrectException;
	
	List<String> getKeys();
	
	void deleteKey(String key);

}
