package com.yoga.exception;

public class KeyNotFoundException  extends Exception{
	
	private String message;
	
	public KeyNotFoundException(String message) {
		super(message);
	}

	public String getMessage() {
		return super.getMessage();
	}
}
