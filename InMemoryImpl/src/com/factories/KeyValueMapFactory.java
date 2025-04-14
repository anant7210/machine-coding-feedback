package com.factories;

import com.factories.interfaces.IKeyValueMapFactory;
import com.map.KeyValueMap;
import com.map.interfaces.IKeyValueMap;

public class KeyValueMapFactory implements IKeyValueMapFactory {

	@Override
	public <Key extends Object, AttributeKey extends Object, AttributeValue extends Object> IKeyValueMap<Key, AttributeKey, AttributeValue> getKeyValueMap() {
		return new KeyValueMap<Key, AttributeKey, AttributeValue>(new AttributeKeyValueMapFactory());
	}

}
