package com.factories.interfaces;

import com.map.interfaces.IKeyValueMap;

public interface IKeyValueMapFactory {
	<Key, AttributeKey, AttributeValue> IKeyValueMap<Key, AttributeKey, AttributeValue> getKeyValueMap();
}
