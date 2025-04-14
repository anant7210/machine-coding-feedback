package com.attribute.typeClasses;

import com.attribute.AttributeKeyValueMap;
import com.exceptions.DataFormatIncorrectException;

public class DoubleAttributeKeyValueMap<Key, Value> extends AttributeKeyValueMap<Double, Key, Value> {

	@Override
	protected Double getValueAsT(Value value) throws DataFormatIncorrectException {
		if (!this.isValidType(value)) {
			throw new DataFormatIncorrectException();
		}
		
		return Double.parseDouble(value.toString());
	}

	@Override
	public boolean isValidType(Value value) {
		try {
			if (value.toString().indexOf('.') == -1) {
				return false;
			}
			Double.parseDouble(value.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
