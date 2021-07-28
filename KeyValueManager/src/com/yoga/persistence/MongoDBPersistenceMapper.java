package com.yoga.persistence;

public class MongoDBPersistenceMapper implements iPersistenceMapper{

	@Override
	public void logCreate(String key, String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void logDelete(String key) {
		throw new UnsupportedOperationException();
	}

}
