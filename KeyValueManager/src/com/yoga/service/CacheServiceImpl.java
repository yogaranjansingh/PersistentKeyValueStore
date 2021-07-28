package com.yoga.service;

import com.yoga.configuration.PersistenceStoreType;
import com.yoga.exception.KeyNotFoundException;
import com.yoga.factory.PersistenceMapperFactory;
import com.yoga.persistence.iPersistenceMapper;
import com.yoga.repository.KeyValueStore;

public class CacheServiceImpl implements CacheService{
	
	KeyValueStore store;
	PersistenceStoreType persistenceStoreType;
	
	public CacheServiceImpl(KeyValueStore keyValueStore, PersistenceStoreType persistenceStoreType) {
		this.store = keyValueStore;
		this.persistenceStoreType = persistenceStoreType;
	}

	@Override
	public String get(String key) throws KeyNotFoundException {
		return store.get(key);
	}

	@Override
	public void create(String key, String value) {
		store.create(key, value);
		iPersistenceMapper persistenceMapper = PersistenceMapperFactory.getPersistenceMapper(persistenceStoreType);
		persistenceMapper.logCreate(key, value);
	}

	@Override
	public void update(String key, String value) {
		store.create(key, value);
		iPersistenceMapper persistenceMapper = PersistenceMapperFactory.getPersistenceMapper(persistenceStoreType);
		persistenceMapper.logCreate(key, value);
	}

	@Override
	public void delete(String key) {
		store.delete(key);
		iPersistenceMapper persistenceMapper = PersistenceMapperFactory.getPersistenceMapper(persistenceStoreType);
		persistenceMapper.logDelete(key);
	}
}
