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

public class KeyValueMap implements IKeyValueMap {
	
	private HashMap<String, IAttributeKeyValueMap> attributeMap;
	
	private HashMap<String, List<String>> keyAttributeMap;
	
	private IAttributeKeyValueMapFactory attributeKeyValueMapFactory;
	
	

	public KeyValueMap(IAttributeKeyValueMapFactory attributeKeyValueMapFactory) {
		this.attributeKeyValueMapFactory = attributeKeyValueMapFactory;
		this.attributeMap = new HashMap<String, IAttributeKeyValueMap>();
		
		this.keyAttributeMap = new HashMap<String, List<String>>();
	}

	@Override
	public IValueAttribute<String, String> get(String key) {
		IValueAttribute<String, String> value = new ValueAttribute();
		
		if (!this.keyAttributeMap.containsKey(key)) {
			return null;
		}
		
		List<String> attributeList = this.keyAttributeMap.get(key);
		
		Iterator<String> it = attributeList.listIterator();
		
		while (it.hasNext()) {
			String next = it.next();
			
			value.setAttribute(next, this.attributeMap.get(next).get(key).toString());
		}
		
		return value;
	}

	@Override
	public void put(String key, IValueAttribute<String, String> value) throws DataFormatIncorrectException {
		if (this.keyAttributeMap.containsKey(key)) {
			this.deleteKey(key);
		}
		
		List<String> attributeList = new ArrayList<String>();
		
		Iterator<String> it = value.getAttributeKeys().listIterator();
		
		while (it.hasNext()) {
			String attkey = it.next();
			
			String attValue = value.getAttribute(attkey);
			
			if (!attributeMap.containsKey(attkey)) {
				this.attributeMap.put(attkey, attributeKeyValueMapFactory.createAttributeKeyValueMap(attValue));
			}
			
			this.attributeMap.get(attkey).put(key, attValue);
			
			attributeList.add(attkey);
		}
		
		this.keyAttributeMap.put(key, attributeList);
		
		System.out.println(this.attributeMap + " " + this.attributeMap.get("att1").get(key));
		
	}

	@Override
	public List<String> getKeyContainingAttributeKeyValuePair(String attribute, String value) throws DataFormatIncorrectException {
		
		if (!this.attributeMap.containsKey(attribute)) {
			return new ArrayList<String>();
		}
		return this.attributeMap.get(attribute).getkeysWithValues(value);
	}

	@Override
	public List<String> getKeys() {
		List<String> keys = new ArrayList<String>();
		
		Iterator<String> it = this.keyAttributeMap.keySet().iterator();
		
		while (it.hasNext()) {
			keys.add(it.next());
		}
		
		return keys;
	}

	@Override
	public void deleteKey(String key) {
		if (!this.keyAttributeMap.containsKey(key)) {
			return;
		}
		
		Iterator<String> it  = this.keyAttributeMap.get(key).listIterator();
		
		while (it.hasNext()) {
			String attribute = it.next();
			
			
			this.attributeMap.get(attribute).deleteKey(key);
			
		}
		
		this.keyAttributeMap.remove(key);
		
		return;
	}

}
