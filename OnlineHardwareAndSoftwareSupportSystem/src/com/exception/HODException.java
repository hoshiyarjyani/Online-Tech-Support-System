package com.exception;

/**
 * 
 * The HODException class is a custom exception that extends the base Exception
 * class in Java.
 * It is designed to be thrown when there is an error related to the Head of
 * Department (HOD) in an educational institution or organization.
 * 
 * @author HoshiyarJyani
 */
public class HODException extends Exception {
	/**
	 * 
	 * Constructs a new HODException with no error message.
	 */
	public HODException() {

	}

	/**
	 * 
	 * Constructs a new HODException with the specified error message.
	 * 
	 * @param msg the error message to display when the exception is thrown
	 */
	public HODException(String msg) {
		super(msg);
	}
}