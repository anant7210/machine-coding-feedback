package com.attribute.interfaces;

import java.util.List;

import com.exceptions.DataFormatIncorrectException;

public interface IAttributeKeyValueMap {
	String get(String key);
	void put(String key, String value) throws DataFormatIncorrectException;
	
	boolean containsKey(String key);
	
	boolean isValidType(String value);
	
	List<String> getkeysWithValues(String value) throws DataFormatIncorrectException;
	
	void deleteKey(String key);
 }
