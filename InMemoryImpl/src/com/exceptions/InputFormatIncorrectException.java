package com.exceptions;

public class InputFormatIncorrectException extends KeyValueStoreException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "INPUT FORMAT INCORRECT";
	}

	
}
