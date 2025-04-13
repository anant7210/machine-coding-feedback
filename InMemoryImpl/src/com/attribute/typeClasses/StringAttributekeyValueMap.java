package com.attribute.typeClasses;

import com.attribute.AttributeKeyValueMap;
import com.exceptions.DataFormatIncorrectException;

public class StringAttributekeyValueMap extends AttributeKeyValueMap<String> {

	@Override
	protected String getValueAsT(String value) throws DataFormatIncorrectException {
		return value;
	}

	@Override
	public boolean isValidType(String value) {
		return true;
	}

}
