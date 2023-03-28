package com.ui;

import java.util.Scanner;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.dto.Employee;
import com.exception.EmployeeException;

public class EmployeeLogIn {

		public int loginEmployee() throws ClassNotFoundException {
			int empId = 0;
			Scanner sc  = new Scanner(System.in);
			System.out.println("Enter Username");
			String username = sc.next();
			System.out.println("Enter Password");
			String password = sc.next();
			System.out.println("==================================");
			
			EmployeeDAO employeeDao = new EmployeeDAOImpl();
			
			try {
				Employee emp = employeeDao.LoginEmployee(username, password);
				System.out.println("Welcome "+ emp.getName());
				System.out.println("======================================");
				empId = emp.getEmpId();
				
			} catch (EmployeeException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				System.out.println("===========================================");
				loginEmployee();
			}
			
			return empId;
		}
	}

