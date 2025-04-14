package com.attribute.typeClasses;

import com.attribute.AttributeKeyValueMap;
import com.exceptions.DataFormatIncorrectException;

public class StringAttributekeyValueMap<Key, Value> extends AttributeKeyValueMap<String, Key, Value> {

	@Override
	protected String getValueAsT(Value value) throws DataFormatIncorrectException {
		return value.toString();
	}

	@Override
	public boolean isValidType(Value value) {
		return true;
	}

}
