package com.ui;

import java.util.Scanner;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.exception.EngineerException;

public class HODAssignComplaintToEngineer {
	public void AssignComplaintToEngineer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("+------------------------------------------------------------------------------------------------------+");
		System.out.println("|                               Assign a Complaint To an Engineer                                      |");
		System.out.println("+------------------------------------------------------------------------------------------------------+");
		
		System.out.println("Enter Complaint-ID that you wants to Assigned.");
		int complaintId = sc.nextInt();
		System.out.println("Enter Engineer-ID to Assign the Complaint.");
		int engineerId = sc.nextInt();
		
		HodDAO dao = new HodDAOImpl();
		try {
			String result = dao.AssignComplaintToEngineerByHOD(complaintId, engineerId);
			System.out.println(result);
		} catch (EngineerException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
