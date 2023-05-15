package com.ui.Hod;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.exception.EngineerException;
import com.ui.Main.UiMain;

/**
 * This class represents the user interface for the registration of an engineer
 * by a Head of Department (HOD).
 * It contains methods to take input from the user such as the engineer's name,
 * username, password, type, and location.
 * It also includes error handling for invalid inputs and exceptions.
 * 
 * @author HoshiyarJyani
 */
public class HodRegisterEngineerUI {

	public void hodRegisterEngineer() throws ClassNotFoundException {
		String res = "Entries are Invalid, Please Write Carefully! Try again.";

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Engineer Name");
		String name = sc.next();
		System.out.println("Enter Engineer's Username");
		String username = sc.next();
		System.out.println("Enter Engineer's Password");
		String password = sc.next();

		System.out.println("Press 1. for Hardware Engineer");
		System.out.println("Press 2. for Software Engineer");

		int typeChoice = 0;
		try {
			typeChoice = sc.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid integer.");
			sc.nextLine();
			hodRegisterEngineer();
		}

		String type = "";

		if (typeChoice == 1) {
			type = "Hardware Engineer";
		} else if (typeChoice == 2) {
			type = "Software Engineer";
		} else {
			System.out.println("Invalid Choice. Please Try Again.");
			hodRegisterEngineer();
		}

		System.out.println("Enter Engineer's Location");
		String location = sc.next();

		HodDAO dao = new HodDAOImpl();

		try {
			res = dao.registerEngineer(name, username, password, type, location);
			System.out.println(res);
		} catch (EngineerException e) {
			System.out.println(e.getMessage());
			hodRegisterEngineer();
		}
	}
}