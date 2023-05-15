package com.ui.Engineer;

import java.util.Scanner;

import com.dao.EngineerDAO;
import com.dao.EngineerDAOImpl;
import com.dto.Engineer;
import com.exception.EngineerException;

/**
 * 
 * The EngineerLogIn class provides a method to log in an engineer by taking
 * input for their
 * username and password, and returns their engineer ID if the login is
 * successful.
 * 
 * @author HoshiyarJyani
 */
public class EngineerLogIn {
	/**
	 * This method takes input for the engineer's username and password and checks
	 * if they
	 * match with an existing engineer's credentials. If successful, it returns the
	 * engineer's ID.
	 *
	 * @return The engineer's ID if the login is successful, otherwise 0.
	 * @throws ClassNotFoundException If the class is not found.
	 * @author HoshiyarJyani
	 */
	public int engineerLogin() throws ClassNotFoundException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();

		EngineerDAO engineerDao = new EngineerDAOImpl();
		int engineerId = 0;

		try {
			Engineer engineer = engineerDao.LogInEngineer(username, password);
			System.out.println(
					"+------------------------------------------------------------------------------------------------------+");
			System.out.println("                                           Welcome " + engineer.getName());
			System.out.println(
					"+------------------------------------------------------------------------------------------------------+");
			engineerId = engineer.getEngId();
		} catch (EngineerException e) {
			System.out.println(e.getMessage());
			engineerLogin();
		}
		return engineerId;
	}
}
