package com.attribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.attribute.interfaces.IValueAttribute;
import com.commonClasses.Pair;

public class ValueAttribute<Key, Value> implements IValueAttribute<Key, Value> {
	
	HashMap<Key, Value> attributeKeyValueMap;

	public ValueAttribute() {
		this.attributeKeyValueMap = new HashMap<Key, Value>();
	}
	
	public ValueAttribute(List<Pair<Key, Value>> attributekeyValueList) {
		this();
		Iterator<Pair<Key, Value>> it =  attributekeyValueList.listIterator();
		
		while (it.hasNext()) {
			Pair<Key, Value> next = it.next();
			this.attributeKeyValueMap.put(next.getKey(), next.getValue());
		}
	}
	
	@Override
	public void setAttribute(Key key, Value value) {
		this.attributeKeyValueMap.put(key, value);

	}

	@Override
	public Value getAttribute(Key key) {
		return this.attributeKeyValueMap.get(key);
	}

	@Override
	public List<Key> getAttributeKeys() {
		List<Key> attributeKeys = new ArrayList<Key>();
		
		Iterator<Key> it =  this.attributeKeyValueMap.keySet().iterator();
		
		while (it.hasNext()) {
			attributeKeys.add(it.next());
		}
		
		return attributeKeys;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		Iterator<Key> it  = this.attributeKeyValueMap.keySet().iterator();
		
		while (it.hasNext()) {
			Key next = it.next();
			
			Value value = this.attributeKeyValueMap.get(next);
			
			sb.append(next);
			sb.append(": ");
			sb.append(value);
			
			if (it.hasNext()) {
				sb.append(", ");
			}
		}
		
		return sb.toString();
	}
	
	

}
