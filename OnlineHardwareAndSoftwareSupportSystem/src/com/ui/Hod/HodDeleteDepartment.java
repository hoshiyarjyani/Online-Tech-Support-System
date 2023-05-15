package com.ui.Hod;

import java.util.Scanner;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.exception.DepartmentException;

/**
 * 
 * This class provides functionality for the HOD to delete a department from the
 * database.
 * The class takes department name as input and calls the HodDAOImpl to perform
 * the delete operation.
 * If an exception occurs, appropriate error message is displayed to the user.
 * 
 * @author HoshiyarJyani
 */
public class HodDeleteDepartment {

	/**
	 * Displays a prompt to the user to enter the name of department that needs to
	 * be deleted.
	 * Calls HodDAOImpl to perform the delete operation and displays the result or
	 * error message.
	 * 
	 * @throws ClassNotFoundException if the HodDAOImpl class is not found.
	 */
	public void hodDeleteDepartment() throws ClassNotFoundException {
		System.out.println(
				"+------------------------------------------------------------------------------------------------------+");
		System.out.println(
				"|                                         Delete Department                                            |");
		System.out.println(
				"+------------------------------------------------------------------------------------------------------+");

		Scanner sc = new Scanner(System.in);
		System.out.println(
				"|                  Enter the Name of Department That You Wants to Delete From Database                 |");

		System.out.println(
				"+------------------------------------------------------------------------------------------------------+");
		String dname = sc.next();
		HodDAO hoddao = new HodDAOImpl();

		try {
			String result = hoddao.DeleteDepartmentByHOD(dname);
			System.out.println(result);
		} catch (DepartmentException e) {
			System.out.println(e.getMessage());
		}
	}
}
