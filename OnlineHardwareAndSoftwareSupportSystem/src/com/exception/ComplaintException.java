package com.exception;

/**
 * 
 * The ComplaintException class is a custom exception that extends the base
 * Exception class in Java.
 * It is designed to be thrown when there is an error related to a complaint in
 * an organization or service.
 * 
 * @author HoshiyarJyani
 */
public class ComplaintException extends Exception {
	/**
	 * 
	 * Constructs a new ComplaintException with the specified error message.
	 * 
	 * @param msg the error message to display when the exception is thrown
	 */
	public ComplaintException(String msg) {
		super(msg);
	}
}
