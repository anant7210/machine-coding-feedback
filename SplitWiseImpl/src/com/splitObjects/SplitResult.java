package com.splitObjects;

import java.util.HashMap;

public class SplitResult {
	HashMap<String, HashMap<String, Double>> owedBy;
	HashMap<String, HashMap<String, Double>> owedTo;
	HashMap<String, Double> owedMap;
	HashMap<String, Double> owesMap;
	
	

	public SplitResult() {
		super();
		this.owedBy = new HashMap<String, HashMap<String,Double>>();
		this.owedTo = new HashMap<String, HashMap<String,Double>>();
		this.owedMap = new HashMap<String, Double>();
		this.owesMap = new HashMap<String, Double>();
	}

	public SplitResult(HashMap<String, HashMap<String, Double>> owedBy, HashMap<String, HashMap<String, Double>> owedTo,
			HashMap<String, Double> owedMap, HashMap<String, Double> owesMap) {
		super();
		this.owedBy = owedBy;
		this.owedTo = owedTo;
		this.owedMap = owedMap;
		this.owesMap = owesMap;
	}

	public HashMap<String, HashMap<String, Double>> getOwedBy() {
		return owedBy;
	}
	public HashMap<String, HashMap<String, Double>> getOwedTo() {
		return owedTo;
	}
}
