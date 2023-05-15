package com.ui.Hod;

import java.util.Scanner;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.dto.HOD;
import com.exception.HODException;

/**
 * 
 * This class is responsible for the login functionality of Head of Department
 * (HOD).
 * It takes username and password as input from the user, and checks if they are
 * valid
 * by calling the loginHodDAO() method from HodDAOImpl class. If the provided
 * credentials
 * are valid, then it displays a welcome message along with the name of the HOD.
 * If the credentials are not valid, then it displays an error message and
 * prompts the
 * user to try again by calling the LoginHOD() method recursively.
 * 
 * @author HoshiyarJyani
 */

public class HodLogin {

	public void LoginHOD() throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username of HOD ");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();

		HodDAO dao = new HodDAOImpl();

		try {
			HOD hod = dao.loginHodDAO(username, password);
			System.out.println(
					"+------------------------------------------------------------------------------------------------------+");
			System.out.println("                                        Welcome " + hod.getName());
			System.out.println(
					"+------------------------------------------------------------------------------------------------------+");

		} catch (HODException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			LoginHOD();
		}
	}
}
