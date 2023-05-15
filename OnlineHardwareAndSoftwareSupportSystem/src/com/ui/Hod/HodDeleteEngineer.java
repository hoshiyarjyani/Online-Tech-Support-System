package com.ui.Hod;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.exception.EngineerException;

/**
 * 
 * This class provides the functionality for the Head of Department (HOD) to
 * delete an engineer from the database.
 * The class prompts the user to enter the ID of the engineer to be deleted, and
 * then calls the DAO layer to delete the
 * engineer from the database.
 * 
 * @author HoshiyarJyani
 */
public class HodDeleteEngineer {

	/**
	 * This method allows the Head of Department (HOD) to delete an engineer from
	 * the database by entering the ID of
	 * the engineer. The method calls the DAO layer to delete the engineer from the
	 * database and displays the result
	 * of the operation.
	 * 
	 * @throws ClassNotFoundException
	 */
	public void hodDeleteEngineer() throws ClassNotFoundException {
		System.out.println(
				"+------------------------------------------------------------------------------------------------------+");
		System.out.println(
				"|                                          Delete Engineer                                             |");
		System.out.println(
				"+------------------------------------------------------------------------------------------------------+");
		Scanner sc = new Scanner(System.in);

		System.out.println(
				"|                     Enter the ID of Engineer That You Wants to Delete From Database                  |");
		System.out.println(
				"+------------------------------------------------------------------------------------------------------+");
		try {
			int engId = sc.nextInt();
			HodDAO hoddao = new HodDAOImpl();

			try {
				String res = hoddao.DeleteEngineerByHodDAO(engId);
				System.out.println(res);
			} catch (EngineerException e) {
				System.out.println(e.getMessage());
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid integer.");
			sc.nextLine();
		}

	}
}