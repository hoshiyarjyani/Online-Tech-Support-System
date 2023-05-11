package com.ui.Hod;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.exception.EngineerException;

/**
 * 
 * The HODAssignComplaintToEngineer class provides a method for assigning a
 * complaint to an engineer by the HOD.
 * It prompts the user to enter the complaint-ID and engineer-ID to assign the
 * complaint.
 * If the input is invalid, it prompts the user to enter a valid integer.
 * It uses the HodDAO and HodDAOImpl classes to perform the database operations
 * and handles any exceptions.
 * 
 * @author HoshiyarJyani
 */
public class HODAssignComplaintToEngineer {

	/**
	 * Assigns a complaint to an engineer by the HOD.
	 * 
	 * @throws InputMismatchException if the user enters an invalid input.
	 * @author HoshiyarJyani
	 */
	public void AssignComplaintToEngineer() {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"+------------------------------------------------------------------------------------------------------+");
		System.out.println(
				"|                               Assign a Complaint To an Engineer                                      |");
		System.out.println(
				"+------------------------------------------------------------------------------------------------------+");

		int complaintId = 0;
		int engineerId = 0;
		try {
			System.out.println("Enter Complaint-ID that you wants to Assigned.");
			complaintId = sc.nextInt();
			System.out.println("Enter Engineer-ID to Assign the Complaint.");
			engineerId = sc.nextInt();
			HodDAO dao = new HodDAOImpl();
			try {
				String result = dao.AssignComplaintToEngineerByHOD(complaintId, engineerId);
				System.out.println(result);
			} catch (EngineerException | ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}

		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid Integer.");
			sc.nextLine();
			AssignComplaintToEngineer();
		}

	}
}
