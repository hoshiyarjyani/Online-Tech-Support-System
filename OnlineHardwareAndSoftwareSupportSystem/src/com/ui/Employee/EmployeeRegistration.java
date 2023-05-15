package com.ui.Employee;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.exception.EmployeeException;

/**
 * 
 * The EmployeeRegistration class allows users to register a new employee by
 * taking input for their department ID,
 * name, username, and password. The password must follow specific criteria,
 * including a length of 8 to 20 characters,
 * at least one digit, one uppercase letter, one lowercase letter, and one
 * special character. The class connects to
 * a database through the EmployeeDAO interface and its implementation class,
 * EmployeeDAOImpl, to register the new
 * employee and store their information in the database.
 * 
 * @author HoshiyarJyani
 */
public class EmployeeRegistration {
	/**
	 * 
	 * This method allows users to input the necessary information to register a new
	 * employee, including department ID,
	 * name, username, and password. It verifies that the department ID is a valid
	 * integer, and that the password follows
	 * specific criteria for length, digit, uppercase letter, lowercase letter, and
	 * special character. If the password
	 * meets the criteria, it connects to the database through the EmployeeDAO
	 * interface and its implementation class,
	 * EmployeeDAOImpl, to register the new employee and store their information in
	 * the database. If the password does not
	 * meet the criteria, the method prompts the user to try again.
	 * 
	 * @throws SQLIntegrityConstraintViolationException if the data entered violates
	 *                                                  a database constraint
	 * @author HoshiyarJyani
	 */

	public void RegisterNewEmployee() throws SQLIntegrityConstraintViolationException {
		System.out.println("Employee Registration");
		System.out.println(
				"================================================================================================================");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Department ID");

		int deptId = 0;
		try {
			deptId = sc.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid integer.");
			sc.nextLine();
			RegisterNewEmployee();
		}

		System.out.println("Enter Name Of Employee");
		String name = sc.next();
		System.out.println("Enter Username here");
		String username = sc.next();
		System.out.println(
				"Enter Your Password here.\nNote- \nPassword Should have 8 to 20 Characters \nWithout Space \nInclude Atleast 1-Digit 1-Uppercase 1-Lowercase and a Special Character.");
		String password = sc.next();

		String regex = "^(?=.*[0-9])"
				+ "(?=.*[a-z])(?=.*[A-Z])"
				+ "(?=.*[@#$%^&+=])"
				+ "(?=\\S+$).{8,20}$";

		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(password);

		if (m.matches()) {

			EmployeeDAO dao = new EmployeeDAOImpl();

			try {
				String res = dao.RegisterEmployee(deptId, name, username, password);
				System.out.println(res);
			} catch (EmployeeException | ClassNotFoundException e) {
				System.out.println(
						"Oops! The data you entered violates a database constraint.\nMay be You Add a Department ID that not Exist in Our System.  \nPlease check your input and try again.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("Password should have 8 to 20 characters without"
					+ "space and should include atleast 1 digit 1 uppercase 1 lowercase letter"
					+ "and a special character. Please try again.");

			RegisterNewEmployee();
		}

	}
}
