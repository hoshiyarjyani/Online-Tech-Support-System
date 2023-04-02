package com.ui.Employee;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.dto.EngineerComplaintsDTO;
import com.exception.ComplaintException;
import com.ui.Main.UiMain;

public class EmployeeCheckComplaintStatus {
	public void CheckComplaintStatusByEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Complaint-ID to check status");
		
		try {
			int compId = sc.nextInt();
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			System.out.println("|                                        Your Complaint Status                                         |");
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			EmployeeDAO dao = new EmployeeDAOImpl();
			
			try {
				EngineerComplaintsDTO dto =  dao.CheckComplaintStatusByEmployee(compId);
				System.out.println("ComplaintId: " + dto.getComplaintId());
				System.out.println("Complaint Type: " + dto.getComplaintType());
				System.out.println("Engineer Id: " + dto.getEngId());
				System.out.println("Engineer Name: " + dto.getName());
				System.out.println("Status: " + dto.getStatus());
				System.out.println("Date Raised: " + dto.getDateRaised());
			} catch (ComplaintException | ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
		} catch (InputMismatchException e) {
		    System.out.println("Invalid input. Please enter a valid integer.");
		    sc.nextLine(); 
		    CheckComplaintStatusByEmployee();
		}
		
	
	}
}
