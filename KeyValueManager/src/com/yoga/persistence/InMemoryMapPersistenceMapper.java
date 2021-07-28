package com.yoga.persistence;

import com.yoga.repository.LogStore;

public class InMemoryMapPersistenceMapper implements iPersistenceMapper{
	
	LogStore logStore;
	
	public InMemoryMapPersistenceMapper(LogStore logStore) {
		this.logStore = logStore;
	}

	@Override
	public void logCreate(String key, String value) {
		logStore.logCreate(key, value);
	}

	@Override
	public void logDelete(String key) {
		logStore.logDelete(key);
	}

}
