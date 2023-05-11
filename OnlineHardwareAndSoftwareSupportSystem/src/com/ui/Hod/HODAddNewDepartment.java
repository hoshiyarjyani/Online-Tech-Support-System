package com.ui.Hod;

import java.util.Scanner;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.exception.DepartmentException;

/**
 * The HODAddNewDepartment class provides the user interface for adding a new
 * department to the system.
 * 
 * @author HoshiyarJyani
 */
public class HODAddNewDepartment {

	/**
	 * This method provides the user interface for registering a new department.
	 * It prompts the user to enter the department name and city, then calls the
	 * RegisterDepartment method of HodDAOImpl class
	 * to add the department to the system.
	 * 
	 * @throws ClassNotFoundException if there is an error in loading the HodDAOImpl
	 *                                class
	 * @author HoshiyarJyani
	 */
	public void HodRegisterDepartment() throws ClassNotFoundException {
		String result = "Entries are Invalid, Please Write Carefully! Try again.";

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Department Name");
		String dname = sc.next();
		System.out.println("Enter Department City");
		String city = sc.next();

		HodDAO dao = new HodDAOImpl();

		try {
			result = dao.RegisterDepartment(dname, city);
			System.out.println(result);
		} catch (DepartmentException e) {
			System.out.println(e.getMessage());
			HodRegisterDepartment();
		}
	}
}
