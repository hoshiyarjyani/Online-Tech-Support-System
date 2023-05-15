package com.exception;

/**
 * 
 * The EmployeeException class is a custom exception that extends the base
 * Exception class in Java.
 * It is designed to be thrown when there is an error related to an employee in
 * an organization.
 * 
 * @author HoshiyarJyani
 */
public class EmployeeException extends Exception {
  /**
   * 
   * Constructs a new EmployeeException with the specified error message.
   * 
   * @param msg the error message to display when the exception is thrown
   */
  public EmployeeException(String msg) {
    super(msg);
  }
}
