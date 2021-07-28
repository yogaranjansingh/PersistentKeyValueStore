package com.yoga.factory;

import com.yoga.configuration.PersistenceStoreType;
import com.yoga.persistence.InMemoryMapPersistenceMapper;
import com.yoga.persistence.MongoDBPersistenceMapper;
import com.yoga.persistence.iPersistenceMapper;
import com.yoga.repository.LogStore;

public class PersistenceMapperFactory {
	
	public static iPersistenceMapper getPersistenceMapper(PersistenceStoreType storeType)
	{
		switch (storeType) {
		case IN_MEMORY_MAP:
			LogStore logStore = new LogStore();
			return new InMemoryMapPersistenceMapper(logStore);
		case MONGO_DB : 
			return new MongoDBPersistenceMapper();
		default:
			return null;
		}
	}
	
}
