package com.attribute.interfaces;

import java.util.List;

public interface IValueAttribute<K, V> {
	String toString();
	
	void setAttribute(K key, V value);
	
	String getAttribute(K key);
	
	List<K> getAttributeKeys();
}
