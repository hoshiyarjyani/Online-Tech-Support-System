package com.ui;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.exception.EmployeeException;

public class EmployeeChangePassword {
	public void EmployeeChangePasswordUI() throws ClassNotFoundException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Username");
		String username = sc.next();
		System.out.println("Enter Your Old Password");
		String oldPassword = sc.next();
		System.out.println("Enter Your New Password Here.\nNote- Password should have 8 to 20 Characters without Space, \nInclude atleast 1 Digit, 1 Uppercase, 1 Lowercase and 1 Special Character.");
		String newPassword = sc.next();

		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";

		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(newPassword);

		if (m.matches()) {
			EmployeeDAO employeeDao = new EmployeeDAOImpl();

			try {
				String result = employeeDao.ChangeEmployeePassword(username, oldPassword, newPassword);
				System.out.println(result);
			} catch (EmployeeException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Enter Your New Password Here.\nNote- Password should have 8 to 20 Characters without Space, \nInclude atleast 1 Digit, 1 Uppercase, 1 Lowercase and 1 Special Character.");
			EmployeeChangePasswordUI();
		}

	}
}
