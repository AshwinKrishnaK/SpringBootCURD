package com.learnwithme.curd.exception;

public class UnExceptedError extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnExceptedError() {};
	
	public UnExceptedError(String message) {
		super(message);
	}
}
