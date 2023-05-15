package com.ui.Hod;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.exception.EmployeeException;

/**
 * 
 * This class represents the functionality for deleting an employee by a Head of
 * Department (HOD).
 * The class provides a method for taking input from the user for the employee
 * ID to be deleted,
 * and calls the appropriate DAO method to delete the employee from the
 * database.
 * If there is an error during the deletion process, an EmployeeException is
 * thrown and caught,
 * with an error message printed to the console.
 * If the user enters an invalid input, an InputMismatchException is caught and
 * an error message is printed to the console,
 * prompting the user to enter a valid integer.
 * 
 * @author HoshiyarJyani
 */
public class HodDeleteEmployee {

	/**
	 * This method provides the functionality for deleting an employee by a Head of
	 * Department (HOD).
	 * The method takes input from the user for the employee ID to be deleted,
	 * and calls the appropriate DAO method to delete the employee from the
	 * database.
	 * If there is an error during the deletion process, an EmployeeException is
	 * thrown and caught,
	 * with an error message printed to the console.
	 * If the user enters an invalid input, an InputMismatchException is caught and
	 * an error message is printed to the console,
	 * prompting the user to enter a valid integer.
	 * 
	 * @throws ClassNotFoundException if the DAO class is not found
	 * @throws EmployeeException      if there is an error during the employee
	 *                                deletion process
	 */
	
	public void HODDeleteEmployee() throws ClassNotFoundException, EmployeeException {
		System.out.println(
				"+------------------------------------------------------------------------------------------------------+");
		System.out.println(
				"|                                         Delete Employee                                              |");
		System.out.println(
				"+------------------------------------------------------------------------------------------------------+");

		Scanner sc = new Scanner(System.in);
		System.out.println(
				"|                    Enter the ID of Employee That You Wants to Delete From Database                   |");

		int empId = 0;
		try {
			empId = sc.nextInt();
			System.out.println(
					"+------------------------------------------------------------------------------------------------------+");

			HodDAO hoddao = new HodDAOImpl();

			try {
				String result = hoddao.DeleteEmployeeByHodDAO(empId);
				System.out.println(result);
			} catch (EmployeeException e) {
				System.out.println(e.getMessage());
			}

		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid integer.");
			sc.nextLine();
			HODDeleteEmployee();

		}

	}
}
