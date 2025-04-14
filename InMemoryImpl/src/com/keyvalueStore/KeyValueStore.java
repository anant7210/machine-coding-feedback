package com.keyvalueStore;

import java.util.List;

import com.attribute.ValueAttribute;
import com.attribute.interfaces.IValueAttribute;
import com.commonClasses.Pair;
import com.exceptions.DataFormatIncorrectException;
import com.factories.interfaces.IKeyValueMapFactory;
import com.keyvalueStore.interfaces.IKeyValueStore;
import com.map.interfaces.IKeyValueMap;

public class KeyValueStore<Key extends Object, AttributeKey extends Object, AttributeValue extends Object> implements IKeyValueStore<Key, AttributeKey, AttributeValue> {
	
	private IKeyValueMap<Key, AttributeKey, AttributeValue> keyValueMap;
	
	private IKeyValueMapFactory keyValueMapFactory;

	public KeyValueStore(IKeyValueMapFactory keyValueMapFactory) {
		this.keyValueMapFactory = keyValueMapFactory;
		
		this.keyValueMap = this.keyValueMapFactory.<Key, AttributeKey, AttributeValue>getKeyValueMap();
	}

	@Override
	public IValueAttribute<AttributeKey, AttributeValue> get(Key key) {
		return this.keyValueMap.get(key);
	}

	@Override
	public List<Key> search(AttributeKey attributeKey, AttributeValue attributeValue) throws DataFormatIncorrectException {
		// TODO Auto-generated method stub
		return this.keyValueMap.getKeyContainingAttributeKeyValuePair(attributeKey, attributeValue);
	}

	@Override
	public void put(Key key, List<Pair<AttributeKey, AttributeValue>> listOfAttributesPair) throws DataFormatIncorrectException {
		this.keyValueMap.put(key, new ValueAttribute<AttributeKey, AttributeValue>(listOfAttributesPair));
	}

	@Override
	public void delete(Key key) {
		this.keyValueMap.deleteKey(key);

	}

	@Override
	public List<Key> keys() {
		return this.keyValueMap.getKeys();
	}


}
