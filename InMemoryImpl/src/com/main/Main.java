package com.main;

import java.util.Arrays;

import com.commonClasses.Pair;
import com.exceptions.DataFormatIncorrectException;
import com.factories.AttributeKeyValueMapFactory;
import com.keyvalueStore.KeyValueStore;
import com.keyvalueStore.interfaces.IKeyValueStore;
import com.map.KeyValueMap;

public class Main {

	public static void main(String[] args) throws DataFormatIncorrectException {
		IKeyValueStore keyValueStore = new KeyValueStore(new KeyValueMap(new AttributeKeyValueMapFactory()));
		
		keyValueStore.put("test1", Arrays.asList(new Pair<String, String>("att1", "123")));
		
		System.out.println(keyValueStore.get("test1"));
		
		System.out.println(keyValueStore.search("att1", "1231"));
		
		System.out.println(keyValueStore.keys());
		
		keyValueStore.delete("test1");
		
		System.out.println(keyValueStore.get("test1"));
		
		keyValueStore.put("test1", Arrays.asList(new Pair<String, String>("att1", "123")));
		
		keyValueStore.put("test2", Arrays.asList(new Pair<String, String>("att1", "123a")));
	}

}
