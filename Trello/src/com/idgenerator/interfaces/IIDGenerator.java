package com.idgenerator.interfaces;

public interface IIDGenerator {
	String generateNextId();
	
	void invalidateId(String id);
}	
