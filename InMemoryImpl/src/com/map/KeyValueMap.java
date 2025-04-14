package com.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.attribute.ValueAttribute;
import com.attribute.interfaces.IAttributeKeyValueMap;
import com.attribute.interfaces.IValueAttribute;
import com.exceptions.DataFormatIncorrectException;
import com.factories.interfaces.IAttributeKeyValueMapFactory;
import com.map.interfaces.IKeyValueMap;

public class KeyValueMap<Key extends Object, AttributeKey extends Object, AttributeValue extends Object> implements IKeyValueMap<Key, AttributeKey, AttributeValue> {
	
	private HashMap<AttributeKey, IAttributeKeyValueMap<Key, AttributeValue>> attributeMap;
	
	private HashMap<Key, List<AttributeKey>> keyAttributeMap;
	
	private IAttributeKeyValueMapFactory attributeKeyValueMapFactory;
	
	

	public KeyValueMap(IAttributeKeyValueMapFactory attributeKeyValueMapFactory) {
		this.attributeKeyValueMapFactory = attributeKeyValueMapFactory;
		this.attributeMap = new HashMap<AttributeKey, IAttributeKeyValueMap<Key, AttributeValue>>();
		
		this.keyAttributeMap = new HashMap<Key, List<AttributeKey>>();
	}

	@Override
	public IValueAttribute<AttributeKey, AttributeValue> get(Key key) {
		IValueAttribute<AttributeKey, AttributeValue> value = new ValueAttribute<AttributeKey, AttributeValue>();
		
		if (!this.keyAttributeMap.containsKey(key)) {
			return null;
		}
		
		List<AttributeKey> attributeList = this.keyAttributeMap.get(key);
		
		Iterator<AttributeKey> it = attributeList.listIterator();
		
		while (it.hasNext()) {
			AttributeKey next = it.next();
			
			value.setAttribute(next, this.attributeMap.get(next).get(key));
		}
		
		return value;
	}

	@Override
	public void put(Key key, IValueAttribute<AttributeKey, AttributeValue> value) throws DataFormatIncorrectException {
		if (this.keyAttributeMap.containsKey(key)) {
			this.deleteKey(key);
		}
		
		List<AttributeKey> attributeList = new ArrayList<AttributeKey>();
		
		Iterator<AttributeKey> it = value.getAttributeKeys().listIterator();
		
		while (it.hasNext()) {
			AttributeKey attkey = it.next();
			
			AttributeValue attValue = value.getAttribute(attkey);
			
			if (!attributeMap.containsKey(attkey)) {
				this.attributeMap.put(attkey, attributeKeyValueMapFactory.createAttributeKeyValueMap(attValue));
			}
			
			this.attributeMap.get(attkey).put(key, attValue);
			
			attributeList.add(attkey);
		}
		
		this.keyAttributeMap.put(key, attributeList);
		
	}

	@Override
	public List<Key> getKeyContainingAttributeKeyValuePair(AttributeKey attribute, AttributeValue value) throws DataFormatIncorrectException {
		
		if (!this.attributeMap.containsKey(attribute)) {
			return new ArrayList<Key>();
		}
		return this.attributeMap.get(attribute).getkeysWithValues(value);
	}

	@Override
	public List<Key> getKeys() {
		List<Key> keys = new ArrayList<Key>();
		
		Iterator<Key> it = this.keyAttributeMap.keySet().iterator();
		
		while (it.hasNext()) {
			keys.add(it.next());
		}
		
		return keys;
	}

	@Override
	public void deleteKey(Key key) {
		if (!this.keyAttributeMap.containsKey(key)) {
			return;
		}
		
		Iterator<AttributeKey> it  = this.keyAttributeMap.get(key).listIterator();
		
		while (it.hasNext()) {
			AttributeKey attribute = it.next();
			
			
			this.attributeMap.get(attribute).deleteKey(key);
			
		}
		
		this.keyAttributeMap.remove(key);
		
		return;
	}

}
