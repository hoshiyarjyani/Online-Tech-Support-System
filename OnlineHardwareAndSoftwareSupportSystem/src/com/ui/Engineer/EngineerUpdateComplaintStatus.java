package com.ui.Engineer;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dao.EngineerDAO;
import com.dao.EngineerDAOImpl;
import com.exception.ComplaintException;

/**
 * 
 * This class allows an engineer to update the status of a complaint by entering
 * the complaint ID and selecting the new status.
 * The method takes the engineer ID as a parameter to ensure that the engineer
 * can only update complaints assigned to them.
 * If the engineer enters an invalid input, they will be prompted to enter a
 * valid input.
 * If the complaint ID or status update fails, an error message will be
 * displayed.
 * 
 * @author HoshiyarJyani
 */

public class EngineerUpdateComplaintStatus {
	/**
	 * This method allows an engineer to update the status of a complaint by
	 * entering the complaint ID and selecting the new status.
	 * The method takes the engineer ID as a parameter to ensure that the engineer
	 * can only update complaints assigned to them.
	 * If the engineer enters an invalid input, they will be prompted to enter a
	 * valid input.
	 * If the complaint ID or status update fails, an error message will be
	 * displayed.
	 *
	 * @param engID The ID of the engineer updating the complaint status
	 * @throws ClassNotFoundException If the specified class cannot be found
	 * @author HoshiyarJyani
	 */
	public void EngineerComplaintStatusUpdate(int engID) throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"+------------------------------------------------------------------------------------------------------+");
		System.out.println(
				"|                          Update Your Status Of Compalint here by ComplaintID                         |");
		System.out.println(
				"+------------------------------------------------------------------------------------------------------+");
		System.out.println("Enter Complaint-ID here.");

		int complaintId = 0;
		try {
			complaintId = sc.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid integer.");
			sc.nextLine();
			EngineerComplaintStatusUpdate(engID);
		}
		System.out.println("1. Set Status of Complaint as 'In Progress'.");
		System.out.println("2. Set Status of Complaint as 'Resolved'.");
		String newStatus = "";

		int status = 0;
		try {
			status = sc.nextInt();
			if (status == 1) {
				newStatus = "In Progress";
				EngineerDAO engineerDao = new EngineerDAOImpl();
				try {
					String res = engineerDao.UpdateComplaintStatusByEngineer(complaintId, newStatus, engID);
					System.out.println(res);
				} catch (ComplaintException e) {
					System.out.println(e.getMessage());
				}
			} else if (status == 2) {
				newStatus = "Resolved";
				EngineerDAO engineerDao = new EngineerDAOImpl();
				try {
					String res = engineerDao.UpdateComplaintStatusByEngineer(complaintId, newStatus, engID);
					System.out.println(res);
				} catch (ComplaintException e) {
					System.out.println(e.getMessage());
				}
			} else {
				System.out.println(
						"+------------------------------------------------------------------------------------------------------+");
				System.out.println(
						"|                                Invalid Selection. Please Try Again                                   |");
				System.out.println(
						"+------------------------------------------------------------------------------------------------------+");
				EngineerComplaintStatusUpdate(engID);
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid integer.");
			sc.nextLine();
			EngineerComplaintStatusUpdate(engID);
		}

	}
}
