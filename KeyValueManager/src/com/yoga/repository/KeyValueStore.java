package com.yoga.repository;

import java.util.HashMap;
import java.util.Map;

import com.yoga.exception.KeyNotFoundException;

public class KeyValueStore {
	
	private static Map<String , String> cache = new HashMap<String, String>();

	public static Map<String, String> getCache() {
		return cache;
	}

	public static void setCache(Map<String, String> cache) {
		KeyValueStore.cache = cache;
	}

	public String get(String key) throws KeyNotFoundException {
		String value = cache.get(key);
		if(value==null) {
			throw new KeyNotFoundException("Specified key was not found, key : "+key);
		}
		return value;
	}

	public void create(String key, String value) {
		cache.put(key, value);
	}

	public void delete(String key) {
		cache.remove(key);
	}
	
	public int getSize()
	{
		return cache.size();
	}
}
