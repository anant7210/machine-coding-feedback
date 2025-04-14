package com.attribute.typeClasses;


import com.attribute.AttributeKeyValueMap;
import com.exceptions.DataFormatIncorrectException;

public class IntegerAttributeKeyValueMap<Key, Value> extends AttributeKeyValueMap<Integer, Key, Value> {

	@Override
	protected Integer getValueAsT(Value value) throws DataFormatIncorrectException {
		
		try {
			return Integer.parseInt(value.toString());
		} catch (Exception e) {
			throw new DataFormatIncorrectException();
		}
	}

	@Override
	public boolean isValidType(Value value) {
		try {
			
			Integer.parseInt(value.toString());
			
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
}
