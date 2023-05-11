package com.ui.Engineer;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dao.EngineerDAO;
import com.dao.EngineerDAOImpl;
import com.exception.EngineerException;

/**
 * 
 * The EngineerChangePassword class provides functionality for an engineer to
 * change their password.
 * The class prompts the user to enter their username and old password, and then
 * enter the new password to be set.
 * The new password must follow specific requirements, such as having 8 to 20
 * characters, at least one digit,
 * one uppercase letter, one lowercase letter, and one special character.
 * If the new password does not meet the requirements, the user is prompted to
 * try again.
 * The class uses the EngineerDAOImpl class to interact with the database and
 * update the password.
 * 
 * @author HoshiyarJyani
 */
public class EngineerChangePassword {
	/**
	 * Prompts the user to enter their username, old password, and new password to
	 * be set.
	 * Checks that the new password meets specific requirements.
	 * Uses the EngineerDAOImpl class to update the password in the database.
	 * 
	 * @throws ClassNotFoundException when the required class is not found
	 * @author HoshiyarJyani
	 */
	public void EngineerPasswordChange() throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Username");
		String userName = sc.next();
		System.out.println("Enter Your Old Password");
		String oldPassword = sc.next();
		System.out.println(
				"+------------------------------------------------------------------------------------------------------+");
		System.out.println(
				"Enter New Password to be set.\nNote- Password should have 8 to 20 Characters.\nNo Space,Include Atleast 1 Digit, 1 Uppercase, 1 Lowercase and a Special Character.");
		System.out.println(
				"+------------------------------------------------------------------------------------------------------+");
		String newPassword = sc.next();

		String regex = "^(?=.*[0-9])"
				+ "(?=.*[a-z])(?=.*[A-Z])"
				+ "(?=.*[@#$%^&+=])"
				+ "(?=\\S+$).{8,20}$";

		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(newPassword);

		if (m.matches()) {
			EngineerDAO engineerDao = new EngineerDAOImpl();

			try {
				String result = engineerDao.ChangeEngineerNewPassword(userName, oldPassword, newPassword);
				System.out.println(result);
			} catch (EngineerException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println(
					"+------------------------------------------------------------------------------------------------------+");
			System.out.println(
					"Oops! Try Again.\nEnter New Password to be set.\nNote- Password should have 8 to 20 Characters.\nNo Space,Include Atleast 1 Digit, 1 Uppercase, 1 Lowercase and a Special Character.");
			System.out.println(
					"+------------------------------------------------------------------------------------------------------+");
			EngineerPasswordChange();
		}
	}
}
