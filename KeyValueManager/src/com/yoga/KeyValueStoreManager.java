package com.yoga;

import java.util.Map;

import com.yoga.configuration.PersistenceStoreType;
import com.yoga.exception.KeyNotFoundException;
import com.yoga.repository.KeyValueStore;
import com.yoga.repository.LogStore;
import com.yoga.service.CacheService;
import com.yoga.service.CacheServiceImpl;

public class KeyValueStoreManager {
	
	public static void main(String[] args) throws KeyNotFoundException {
		
		KeyValueStore keyValueStore = new KeyValueStore();
		CacheService cacheService = new CacheServiceImpl(keyValueStore, PersistenceStoreType.IN_MEMORY_MAP);
	
		LogStore logStore = new LogStore();
		logStore.restoreKeyValueStore();
		
		cacheService.create("one", "1");
		cacheService.create("two", "3");
		cacheService.delete("one");
		cacheService.update("two", "2.0");

		// stop the application and run again
		System.out.println(cacheService.get("one"));
		System.out.println(cacheService.get("two"));
		
	}
}
