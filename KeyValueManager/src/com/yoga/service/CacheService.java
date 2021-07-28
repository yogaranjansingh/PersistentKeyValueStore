package com.yoga.service;

import com.yoga.exception.KeyNotFoundException;

public interface CacheService {
	
	public String get(String key) throws KeyNotFoundException;
	
	public void create(String key, String value);
	
	public void update(String key, String value);
	
	public void delete(String key);

}
