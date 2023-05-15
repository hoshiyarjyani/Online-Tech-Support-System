package com.exception;

/**
 * 
 * The NoRecordFoundException class is a custom exception that extends the base
 * Exception class in Java.
 * It is designed to be thrown when a specific record cannot be found in a
 * database or some other data storage mechanism.
 * 
 * @author HoshiyarJyani
 */
public class NoRecordFoundException extends Exception {
  /**
   * 
   * Constructs a new NoRecordFoundException with the specified error message.
   * @param msg the error message to display when the exception is thrown
   */
  public NoRecordFoundException(String msg) {
    super(msg);
  }
}
