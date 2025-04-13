package com.attribute.typeClasses;


import com.attribute.AttributeKeyValueMap;
import com.exceptions.DataFormatIncorrectException;

public class IntegerAttributeKeyValueMap extends AttributeKeyValueMap<Integer> {

	@Override
	protected Integer getValueAsT(String value) throws DataFormatIncorrectException {
		
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			throw new DataFormatIncorrectException();
		}
	}

	@Override
	public boolean isValidType(String value) {
		try {
			
			Integer.parseInt(value);
			
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
}
