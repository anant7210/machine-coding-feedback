package com.keyvalueStore.interfaces;

import java.util.List;

import com.attribute.interfaces.IValueAttribute;
import com.commonClasses.Pair;
import com.exceptions.DataFormatIncorrectException;


public interface IKeyValueStore<Key extends Object, AttributeKey extends Object, AttributeValue extends Object> {
	
	IValueAttribute<AttributeKey, AttributeValue> get(Key key);
	
	List<Key> search(AttributeKey attributeKey, AttributeValue attributeValue) throws DataFormatIncorrectException;
	
	void put(Key key, List<Pair<AttributeKey, AttributeValue>> listOfAttributesPair) throws DataFormatIncorrectException;
	
	void delete(Key key);
	
	List<Key> keys();
}
