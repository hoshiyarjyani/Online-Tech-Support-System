package com.exception;

/**
 * 
 * The EngineerException class is a custom exception that extends the base
 * Exception class in Java.
 * It is designed to be thrown when there is an error related to an engineer or
 * engineering process.
 * 
 * @author HoshiyarJyani
 */
public class EngineerException extends Exception {
	/**
	 * 
	 * Constructs a new EngineerException with no error message.
	 */
	public EngineerException() {

	}

	/**
	 * 
	 * Constructs a new EngineerException with the specified error message.
	 * 
	 * @param msg the error message to display when the exception is thrown
	 */
	public EngineerException(String msg) {
		super(msg);
	}
}
