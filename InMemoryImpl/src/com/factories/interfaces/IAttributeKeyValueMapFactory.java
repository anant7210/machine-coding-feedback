package com.factories.interfaces;

import com.attribute.interfaces.IAttributeKeyValueMap;

public interface IAttributeKeyValueMapFactory {
	<K, V> IAttributeKeyValueMap<K, V> createAttributeKeyValueMap(V value);
}
