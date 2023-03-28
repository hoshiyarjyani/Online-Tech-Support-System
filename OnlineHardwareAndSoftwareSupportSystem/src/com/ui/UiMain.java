package com.ui;

import java.util.Scanner;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.exception.NoRecordFoundException;

public class UiMain {
	public static void main(String[] args) throws ClassNotFoundException, NoRecordFoundException {
		System.out.println("Welcome to Online Hardware and Software Support System. ");
		System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
		System.out.println("========Select your Option========\n");
		System.out.println("Press 1 if you are the HOD.");
		System.out.println("Press 2 if you are an Employee.");
		System.out.println("Press 3 if you are an Engineer.");
		System.out.println("Press 4 if you want Stop/Exit Application");

		Scanner sc = new Scanner(System.in);

		int choice = sc.nextInt();

		System.out.println("================================");

		switch (choice) {

		case 1:
			System.out.println("HOD");
			System.out.println("================================");
			HodLogin login = new HodLogin();
			login.LoginHOD();
			while (true) {
				System.out.println("Enter 1 : Register a new Engineer.");
				System.out.println("Enter 2 : See the list of all Engineers.");
				System.out.println("Enter 3 : Delete any Engineer.");
				System.out.println("Enter 4 : View all Raised Complaints");
				System.out.println("Enter 5 : Assign a Complaint To an Engineer.");
				System.out.println("Enter 6 : Logout");

				int hodChoice = sc.nextInt();
				System.out.println("===================================");

				if (hodChoice == 1) {
					HodRegisterEngineerUI reg = new HodRegisterEngineerUI();
					System.out.println("Register a new Engineer.");
					System.out.println("=============================================");
					reg.hodRegisterEngineer();
				}

				else if (hodChoice == 2) {
					HodCheckEngineersUI checkEngineersList = new HodCheckEngineersUI();
					System.out.println("Engineers List");
					System.out.println("=================================");
					checkEngineersList.hodCheckEngineers();
				}

				else if (hodChoice == 3) {
					HodDeleteEngineer delete = new HodDeleteEngineer();
					delete.hodDeleteEngineer();
					System.out.println("====================================");
				}

				else if (hodChoice == 4) {

				}

				else if (hodChoice == 5) {

				}

				else if (hodChoice == 6) {
					UiMain.main(args);
				}

				else {
					System.out.println("Invalid choice. Please enter a correct choice.");
					System.out.println("====================================================");

				}
			}

		case 2:
			while (true) {
				System.out.println("Employee.");
				System.out.println("==================================================");
				System.out.println("Enter 1 to login if you are already registered.");
				System.out.println("Enter 2 to register to the system if you are a new employee.");
				System.out.println("Enter 3 to exit.");

			}
		case 3:
			System.out.println("System Engineer");
			System.out.println("==================================================");

			System.out.println("=================================================");

			while (true) {

			}

		case 4:
			System.out.println("Thank you.");
			System.exit(0);

		}
	}
}
