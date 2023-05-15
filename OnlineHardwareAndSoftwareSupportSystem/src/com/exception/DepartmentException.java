package com.exception;

/**
 * 
 * The DepartmentException class is a custom exception that extends the base
 * Exception class in Java.
 * It is designed to be thrown when there is an error related to a department in
 * an organization.
 * 
 * @author HoshiyarJyani
 */
public class DepartmentException extends Exception {
  /**
   * 
   * Constructs a new DepartmentException with the specified error message.
   * 
   * @param msg the error message to display when the exception is thrown
   */
  public DepartmentException(String msg) {
    super(msg);
  }
}
