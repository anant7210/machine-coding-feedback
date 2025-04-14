package com.ioParser.interfaces;

import java.util.List;

import com.attribute.interfaces.IValueAttribute;

public interface IResultFormatter<Key, Attributekey, AttributeValue> {
	String getResultString(IValueAttribute<Attributekey, AttributeValue> valueAttribute);
	String getResultString(List<Key> keys);
}
