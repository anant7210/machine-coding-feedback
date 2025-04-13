package com.attribute.typeClasses;

import com.attribute.AttributeKeyValueMap;
import com.exceptions.DataFormatIncorrectException;

public class DoubleAttributeKeyValueMap extends AttributeKeyValueMap<Double> {

	@Override
	protected Double getValueAsT(String value) throws DataFormatIncorrectException {
		try {
			return Double.parseDouble(value);
		} catch (Exception e) {
			throw new DataFormatIncorrectException();
		}
	}

	@Override
	public boolean isValidType(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
