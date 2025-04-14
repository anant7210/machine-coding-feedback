package com.attribute.typeClasses;

import com.attribute.AttributeKeyValueMap;
import com.exceptions.DataFormatIncorrectException;

public class BooleanAttributeKeyValueMap<Key extends Object, Value extends Object> extends AttributeKeyValueMap<Boolean, Key, Value> {

	@Override
	protected Boolean getValueAsT(Value value) throws DataFormatIncorrectException {
		try {
			return Boolean.parseBoolean(value.toString());
		} catch (Exception e) {
			throw new DataFormatIncorrectException();
		}
	}

	@Override
	public boolean isValidType(Value value) {
		try {
			Boolean.parseBoolean(value.toString());
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
