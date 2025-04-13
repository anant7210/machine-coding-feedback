package com.attribute.typeClasses;

import com.attribute.AttributeKeyValueMap;
import com.exceptions.DataFormatIncorrectException;

public class BooleanAttributeKeyValueMap extends AttributeKeyValueMap<Boolean> {

	@Override
	protected Boolean getValueAsT(String value) throws DataFormatIncorrectException {
		try {
			return Boolean.parseBoolean(value);
		} catch (Exception e) {
			throw new DataFormatIncorrectException();
		}
	}

	@Override
	public boolean isValidType(String value) {
		try {
			Boolean.parseBoolean(value);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
