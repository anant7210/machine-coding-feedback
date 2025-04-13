package com.attribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.attribute.interfaces.IValueAttribute;
import com.commonClasses.Pair;

public class ValueAttribute implements IValueAttribute<String, String> {
	
	HashMap<String, String> attributeKeyValueMap;

	public ValueAttribute() {
		this.attributeKeyValueMap = new HashMap<String, String>();
	}
	
	public ValueAttribute(List<Pair<String, String>> attributekeyValueList) {
		this();
		Iterator<Pair<String, String>> it =  attributekeyValueList.listIterator();
		
		while (it.hasNext()) {
			Pair<String, String> next = it.next();
			this.attributeKeyValueMap.put(next.getKey(), next.getValue());
		}
	}
	
	@Override
	public void setAttribute(String key, String value) {
		this.attributeKeyValueMap.put(key, value);

	}

	@Override
	public String getAttribute(String key) {
		return this.attributeKeyValueMap.get(key);
	}

	@Override
	public List<String> getAttributeKeys() {
		List<String> attributeKeys = new ArrayList<String>();
		
		Iterator<String> it =  this.attributeKeyValueMap.keySet().iterator();
		
		while (it.hasNext()) {
			attributeKeys.add(it.next());
		}
		
		return attributeKeys;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		Iterator<String> it  = this.attributeKeyValueMap.keySet().iterator();
		
		while (it.hasNext()) {
			String next = it.next();
			
			String value = this.attributeKeyValueMap.get(next);
			
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
