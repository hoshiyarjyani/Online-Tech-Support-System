package com.ui.Engineer;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dao.EngineerDAO;
import com.dao.EngineerDAOImpl;
import com.exception.ComplaintException;

public class EngineerUpdateComplaintStatus {
	public void EngineerComplaintStatusUpdate(int engID) throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("+------------------------------------------------------------------------------------------------------+");
		System.out.println("|                          Update Your Status Of Compalint here by ComplaintID                         |");
		System.out.println("+------------------------------------------------------------------------------------------------------+");
		System.out.println("Enter Complaint-ID here.");
		
		int complaintId=0;
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
			if(status==1) {
				newStatus = "In Progress";
				EngineerDAO engineerDao = new EngineerDAOImpl();
				try {
					String res = engineerDao.UpdateComplaintStatusByEngineer(complaintId, newStatus, engID);
					System.out.println(res);
				} catch (ComplaintException e) {
					System.out.println(e.getMessage());
				}
			}else if(status==2) {
				newStatus = "Resolved";
				EngineerDAO engineerDao = new EngineerDAOImpl();
				try {
					String res = engineerDao.UpdateComplaintStatusByEngineer(complaintId, newStatus, engID);
					System.out.println(res);
				} catch (ComplaintException e) {
					System.out.println(e.getMessage());
				}
			}else {
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				System.out.println("|                                Invalid Selection. Please Try Again                                   |");
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				EngineerComplaintStatusUpdate(engID);
			}
			} catch (InputMismatchException e) {
			    System.out.println("Invalid input. Please enter a valid integer.");
			    sc.nextLine(); 
			    EngineerComplaintStatusUpdate(engID);
			}
		
		
	}
}
