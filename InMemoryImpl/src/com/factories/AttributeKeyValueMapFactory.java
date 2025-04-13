package com.factories;

import com.attribute.interfaces.IAttributeKeyValueMap;
import com.attribute.typeClasses.BooleanAttributeKeyValueMap;
import com.attribute.typeClasses.DoubleAttributeKeyValueMap;
import com.attribute.typeClasses.IntegerAttributeKeyValueMap;
import com.attribute.typeClasses.StringAttributekeyValueMap;
import com.factories.interfaces.IAttributeKeyValueMapFactory;

public class AttributeKeyValueMapFactory implements IAttributeKeyValueMapFactory {

	@Override
	public IAttributeKeyValueMap createAttributeKeyValueMap(String value) {
		try {
			Integer.parseInt(value);
			
			return new IntegerAttributeKeyValueMap();
		} catch (Exception e) {
			// do nothing
		}
		
		try {
			Double.parseDouble(value);
			
			return new DoubleAttributeKeyValueMap();
		} catch (Exception e) {
			// Do nothing
		}
		
		try {
			Boolean.parseBoolean(value);
			
			return new BooleanAttributeKeyValueMap();
		} catch (Exception e) {
			return new StringAttributekeyValueMap();
		}
	}

}
