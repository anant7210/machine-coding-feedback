package com.map.interfaces;

import java.util.List;

import com.attribute.interfaces.IValueAttribute;
import com.exceptions.DataFormatIncorrectException;

public interface IKeyValueMap<Key extends Object, AttributeKey extends Object, AttributeValue extends Object> {
	IValueAttribute<AttributeKey, AttributeValue> get(Key key);
	
	void put(Key key, IValueAttribute<AttributeKey, AttributeValue> value) throws DataFormatIncorrectException;
	
	List<Key> getKeyContainingAttributeKeyValuePair(AttributeKey attribute, AttributeValue value) throws DataFormatIncorrectException;
	
	List<Key> getKeys();
	
	void deleteKey(Key key);

}
