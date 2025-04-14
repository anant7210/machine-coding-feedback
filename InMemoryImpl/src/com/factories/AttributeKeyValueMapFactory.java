package com.factories;

import com.attribute.interfaces.IAttributeKeyValueMap;
import com.attribute.typeClasses.BooleanAttributeKeyValueMap;
import com.attribute.typeClasses.DoubleAttributeKeyValueMap;
import com.attribute.typeClasses.IntegerAttributeKeyValueMap;
import com.attribute.typeClasses.StringAttributekeyValueMap;
import com.factories.interfaces.IAttributeKeyValueMapFactory;

public class AttributeKeyValueMapFactory implements IAttributeKeyValueMapFactory {

	@Override
	public <Key, Value> IAttributeKeyValueMap<Key, Value> createAttributeKeyValueMap(Value value) {
		try {
			Integer.parseInt(value.toString());
			
			return new IntegerAttributeKeyValueMap<Key, Value>();
		} catch (Exception e) {
			// do nothing
		}
		
		try {
			Double.parseDouble(value.toString());
			
			return new DoubleAttributeKeyValueMap<Key, Value>();
		} catch (Exception e) {
			// Do nothing
		}
		
		try {
			Boolean.parseBoolean(value.toString());
			
			return new BooleanAttributeKeyValueMap<Key, Value>();
		} catch (Exception e) {
			return new StringAttributekeyValueMap<Key, Value>();
		}
	}

}
