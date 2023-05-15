package com.ui.Employee;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.exception.ComplaintException;

/**
 * 
 * The EmployeeRaiseComplaint class represents the user interface for an
 * employee to raise a complaint.
 * The class provides a method to take input from the user regarding the type of
 * complaint,
 * and saves the complaint in the database.
 * The class uses the EmployeeDAOImpl class to access the database and raise the
 * complaint.
 * The class throws a ComplaintException when there is an issue with raising the
 * complaint.
 * 
 * @author HoshiyarJyani
 */
public class EmployeeRaiseComplaint {
	/**
	 * This method takes an employee ID as input and allows the employee to raise a
	 * complaint.
	 * It prompts the user to select the type of complaint from a list of options,
	 * and then
	 * saves the complaint in the database using the EmployeeDAOImpl class.
	 * The method throws a ComplaintException when there is an issue with raising
	 * the complaint.
	 * 
	 * @param empId The employee ID of the employee raising the complaint.
	 * @throws ClassNotFoundException Thrown when the EmployeeDAOImpl class is not
	 *                                found.
	 * @author HoshiyarJyani
	 */
	public void RaiseComplaintByEmployee(int empId) throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select The Option (Type Of Complaint)\n");
		System.out.println("1. Hardware Complaint.");
		System.out.println("2. Software Complaint.");

		try {
			int option = sc.nextInt();

			String complaintType = "Not Specified By Employee";
			if (option == 1) {
				complaintType = "Hardware";
			} else if (option == 2) {
				complaintType = "Software";
			} else {
				System.out.println(
						"+------------------------------------------------------------------------------------------------------+");
				System.out.println(
						"|                           Oops! Invalid Selection. Please Try Again                                  |");
				System.out.println(
						"+------------------------------------------------------------------------------------------------------+");
				RaiseComplaintByEmployee(empId);
			}
			EmployeeDAO empDao = new EmployeeDAOImpl();
			try {
				int complaintId = empDao.RaiseComplaintByTheEmployee(empId, complaintType);
				System.out.println(
						"+------------------------------------------------------------------------------------------------------+");
				System.out.println(
						"|        Please Save This number for checking the status of your complaint in future                   |");
				System.out.println(
						"+------------------------------------------------------------------------------------------------------+");
				System.out.println("Your Complaint Number is " + complaintId);
				System.out.println(
						"+------------------------------------------------------------------------------------------------------+");
			} catch (ComplaintException e) {
				System.out.println(e.getMessage());
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid integer.");
			sc.nextLine();
			RaiseComplaintByEmployee(empId);
		}

	}
}
