package com.ui;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.exception.EmployeeException;

public class EmployeeRegistration {
		
		public void RegisterNewEmployee() throws SQLIntegrityConstraintViolationException {
			System.out.println("Employee Registration");
			System.out.println("=============================");
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Department ID");
			int deptId = sc.nextInt();
			System.out.println("Enter Name Of Employee");
			String name = sc.next();
			System.out.println("Enter Username here");
			String username = sc.next();
			System.out.println("Enter Your Password here.\nNote- \nPassword Should have 8 to 20 Characters \nWithout Space \nInclude Atleast 1-Digit 1-Uppercase 1-Lowercase and a Special Character.");
			String password = sc.next();
			
			String regex = "^(?=.*[0-9])"
	                + "(?=.*[a-z])(?=.*[A-Z])"
	                + "(?=.*[@#$%^&+=])"
	                + "(?=\\S+$).{8,20}$";
			
			Pattern p = Pattern.compile(regex);
			
			Matcher m = p.matcher(password);
			
			if(m.matches()) {
				
				EmployeeDAO dao = new EmployeeDAOImpl();
				
				try {
				    String res = dao.RegisterEmployee(deptId, name, username, password);
				    System.out.println(res);
				} catch (EmployeeException | ClassNotFoundException e) {
				    System.out.println("Oops! The data you entered violates a database constraint.\nMay be You Add a Department ID that not Exist in Our System.  \nPlease check your input and try again.");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				System.out.println("Password should have 8 to 20 characters without"
						+"space and should include atleast 1 digit 1 uppercase 1 lowercase letter"
						+"and a special character. Please try again.");
				
				RegisterNewEmployee();
			}
			
		}
	}
