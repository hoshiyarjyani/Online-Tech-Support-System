package com.ui.Hod;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.exception.EmployeeException;

public class HodDeleteEmployee {
	public void HODDeleteEmployee() throws ClassNotFoundException, EmployeeException {
		System.out.println("+------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                         Delete Employee                                              |");
		System.out.println("+------------------------------------------------------------------------------------------------------+");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("|                    Enter the ID of Employee That You Wants to Delete From Database                   |");
		
		int empId = 0;
		try {
			 empId = sc.nextInt();
			 System.out.println("+------------------------------------------------------------------------------------------------------+");
				
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
