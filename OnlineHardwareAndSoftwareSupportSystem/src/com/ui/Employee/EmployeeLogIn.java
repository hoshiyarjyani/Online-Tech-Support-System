package com.ui.Employee;

import java.util.Scanner;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.dto.Employee;
import com.exception.EmployeeException;

/**
 * 
 * This class represents the functionality of logging in as an employee into the
 * system.
 * It takes input for username and password and passes them to the EmployeeDAO
 * to authenticate.
 * If the authentication is successful, it returns the employee ID.
 * If the authentication fails, it prompts the user to enter the credentials
 * again.
 * 
 * @author HoshiyarJyani
 */
public class EmployeeLogIn {
	/**
	 * This method is used for logging in an employee.
	 * It prompts the user to enter their username and password.
	 * If the credentials match with an employee in the system, it returns the
	 * employee ID.
	 * If the credentials do not match, it prompts the user to enter the credentials
	 * again.
	 * 
	 * @return int - employee ID if the authentication is successful.
	 * @throws ClassNotFoundException if the JDBC driver is not found.
	 * @author HoshiyarJyani
	 */
	public int loginEmployee() throws ClassNotFoundException {
		int empId = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();

		EmployeeDAO employeeDao = new EmployeeDAOImpl();

		try {
			Employee emp = employeeDao.LoginEmployee(username, password);
			System.out.println(
					"+------------------------------------------------------------------------------------------------------+");
			System.out.println("                                           Welcome " + emp.getName());
			System.out.println(
					"+------------------------------------------------------------------------------------------------------+");
			empId = emp.getEmpId();

		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			loginEmployee();
		}

		return empId;
	}
}
