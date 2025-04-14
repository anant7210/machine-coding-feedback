package com.attribute.interfaces;

import java.util.List;

import com.exceptions.DataFormatIncorrectException;

public interface IAttributeKeyValueMap<K, V> {
	V get(K key);
	void put(K key, V value) throws DataFormatIncorrectException;
	
	boolean containsKey(K key);
	
	boolean isValidType(V value);
	
	List<K> getkeysWithValues(V value) throws DataFormatIncorrectException;
	
	void deleteKey(K key);
 }
