package com.ioParser.interfaces;

import java.util.List;

import com.commonClasses.Pair;
import com.exceptions.KeyValueStoreException;

public interface IInputFormatter<Key, AttributeKey, AttributeValue> {
	Pair<Key, List<Pair<AttributeKey, AttributeValue>>> parsePutOperationInput(String[] input) throws KeyValueStoreException;
	
	Pair<AttributeKey, AttributeValue> parseSearchOperationInput(String[] input) throws KeyValueStoreException;
	
	Key parseGetOperationInput(String[] input) throws KeyValueStoreException;
	
	Key parseDeleteOperationInput(String[] input) throws KeyValueStoreException;
}
