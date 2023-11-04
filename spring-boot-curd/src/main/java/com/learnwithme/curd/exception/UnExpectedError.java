package com.learnwithme.curd.exception;

public class UnExpectedError extends Exception{

	/**
	 * Expected
	 */
	private static final long serialVersionUID = 1L;

	public UnExpectedError() {};
	
	public UnExpectedError(String message) {
		super(message);
	}
}
