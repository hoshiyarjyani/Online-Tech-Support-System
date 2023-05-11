package com.ui.Employee;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.exception.EmployeeException;

/**
 * 
 * The EmployeeChangePassword class provides functionality to allow an employee
 * to change their password.
 * The class prompts the employee to enter their username, old password, and new
 * password, and validates the
 * new password against a regular expression before updating the password in the
 * database.
 * 
 * @author HoshiyarJyani
 */
public class EmployeeChangePassword {
	/**
	 * This method displays the user interface for the employee to change their
	 * password.
	 * It prompts the user to enter their username, old password, and new password,
	 * validates the new password against a regular expression
	 * before updating the password in the database. If the entered new password
	 * does not meet the requirements, the user is prompted again.
	 * 
	 * @throws ClassNotFoundException if the database driver class is not found
	 * @author HoshiyarJyani
	 */
	public void EmployeeChangePasswordUI() throws ClassNotFoundException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Username");
		String username = sc.next();
		System.out.println("Enter Your Old Password");
		String oldPassword = sc.next();
		System.out.println(
				"Enter Your New Password Here.\nNote- Password should have 8 to 20 Characters without Space, \nInclude atleast 1 Digit, 1 Uppercase, 1 Lowercase and 1 Special Character.");
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
			System.out.println(
					"Enter Your New Password Here.\nNote- Password should have 8 to 20 Characters without Space, \nInclude atleast 1 Digit, 1 Uppercase, 1 Lowercase and 1 Special Character.");
			EmployeeChangePasswordUI();
		}

	}
}
