package com.yoga.persistence;

public interface iPersistenceMapper {
	
	public void logCreate(String key, String value);
	
	public void logDelete(String key);

}
