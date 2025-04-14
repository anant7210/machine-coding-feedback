package com.keyvalueStore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.commonClasses.Pair;
import com.enums.Operations;
import com.exceptions.InputFormatIncorrectException;
import com.exceptions.KeyValueStoreException;
import com.factories.KeyValueMapFactory;
import com.ioParser.InputFormatter;
import com.ioParser.ResultFormatter;
import com.ioParser.interfaces.IInputFormatter;
import com.ioParser.interfaces.IResultFormatter;
import com.keyvalueStore.interfaces.IKeyValueStore;
import com.keyvalueStore.interfaces.IKeyValueStoreInterface;

public class KeyValueStoreInterface implements IKeyValueStoreInterface {

	private IKeyValueStore<String, String, String> keyValueStore;
	
	private IResultFormatter<String, String, String> resultFormatter;
	
	private IInputFormatter<String, String, String> inputFormatter;
	
	
	public KeyValueStoreInterface() {
		this.keyValueStore = new KeyValueStore<String, String, String>(new KeyValueMapFactory());
		this.inputFormatter = new InputFormatter();
		
		this.resultFormatter = new ResultFormatter();
	}


	@Override
	public List<String> returnResult(List<String> input) {
		List<String> result = new ArrayList<String>();
		
		Iterator<String> it = input.listIterator();
		
		while (it.hasNext()) {
			try {
				result.add(this.processInput(it.next()));
			} catch (KeyValueStoreException e) {
				result.add(e.getMessage());
			}
		}
		
		return result;
	}
	
	private String processInput(String inputString) throws KeyValueStoreException {
		String[] parts = inputString.split(" ");
		
		if (parts.length == 0) {
			throw new InputFormatIncorrectException();
		}
		
		try {
			Operations operation = Operations.valueOf(parts[0].toUpperCase());
			
			switch (operation) {
			case PUT:
				return this.parseAndExecutePUTOperation(parts);
			case DELETE:
				return this.parseAndExecuteDELETEOperation(parts);
			case GET:
				
				return this.parseAndExecuteGETOperation(parts);
			case KEYS:
				return this.parseAndExecuteKEYSOperation();
			case SEARCH:
				return this.parseAndExecuteSEARCHOperation(parts);
			default:
				return "";
				
			}
		} catch(KeyValueStoreException dataException) {
			throw dataException;
		} catch (Exception e) {
			e.printStackTrace();
			throw new InputFormatIncorrectException();
		}
		
		
	}


	private String parseAndExecuteKEYSOperation() throws KeyValueStoreException {
		
		return this.resultFormatter.getResultString(this.keyValueStore.keys());
	}


	private String parseAndExecuteGETOperation(String[] parts) throws KeyValueStoreException {
		
		String input = this.inputFormatter.parseGetOperationInput(parts);
		
		
		String result = this.resultFormatter.getResultString(this.keyValueStore.get(this.inputFormatter.parseGetOperationInput(parts)));
		
		if (result.equals("")) {
			return "No entry found for " +  input;
		}
		
		return result;
	}


	private String parseAndExecuteDELETEOperation(String[] parts) throws KeyValueStoreException {
		
		
		this.keyValueStore.delete(this.inputFormatter.parseDeleteOperationInput(parts));
		
		return null;
	}


	private String parseAndExecutePUTOperation(String[] parts) throws KeyValueStoreException {
		Pair<String, List<Pair<String, String>>> input = this.inputFormatter.parsePutOperationInput(parts);
		
		this.keyValueStore.put(input.getKey(), input.getValue());
		
		return "";
	}
	
	private String parseAndExecuteSEARCHOperation(String[] parts) throws KeyValueStoreException {
		Pair<String, String> input = this.inputFormatter.parseSearchOperationInput(parts);
		List<String> result = this.keyValueStore.search(input.getKey(), input.getValue());
		
		return this.resultFormatter.getResultString(result);
	}

}
