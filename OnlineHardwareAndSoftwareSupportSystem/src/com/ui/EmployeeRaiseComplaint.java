package com.ui;

import java.util.Scanner;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.exception.ComplaintException;

public class EmployeeRaiseComplaint {
	public void RaiseComplaintByEmployee(int empId) throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select The Option (Type Of Complaint)\n");
		System.out.println("1. Hardware Complaint.");
		System.out.println("2. Software Complaint.");
		int option = sc.nextInt();
		String complaintType = "Not Specified By Employee";
		if(option==1) {
			complaintType="Hardware";
		}else if(option==2) {
			complaintType ="Software";
		}else {
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			System.out.println("|                           Oops! Invalid Selection. Please Try Again                                  |");
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			RaiseComplaintByEmployee(empId);
		}
		EmployeeDAO empDao = new EmployeeDAOImpl();
		try {
			int complaintId = empDao.RaiseComplaintByTheEmployee(empId, complaintType);
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			System.out.println("|        Please Save This number for checking the status of your complaint in future                   |");
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			System.out.println("Your Complaint Number is "+ complaintId);
			System.out.println("+------------------------------------------------------------------------------------------------------+");
		} catch (ComplaintException e) {
			System.out.println(e.getMessage());
		}
	}
}

