package com.ui;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.exception.NoRecordFoundException;

public class UiMain {
	public static void main(String[] args) throws ClassNotFoundException, NoRecordFoundException, SQLIntegrityConstraintViolationException {
		System.out.println("Welcome to Online Hardware and Software Support System. ");
		System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
		System.out.println("========Select your Option========\n");
		System.out.println("Enter 1 If you are the HOD.");
		System.out.println("Enter 2 If you are an Employee.");
		System.out.println("Enter 3 If you are an Engineer.");
		System.out.println("Enter 4 Stop/Exit Application");

		Scanner sc = new Scanner(System.in);

		int choice = sc.nextInt();

		System.out.println("================================");

		switch (choice) {

		case 1:
			System.out.println("HOD Section");
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
					HodCheckComplaints checkComplaints = new HodCheckComplaints();
					System.out.println("All Complaints");
					System.out.println("=====================================");
					checkComplaints.CheckAllComplaintsByHOD();
					System.out.println("=====================================");
				}

				else if (hodChoice == 5) {
					HODAssignComplaintToEngineer assignComplain = new HODAssignComplaintToEngineer();
					assignComplain.AssignComplaintToEngineer();
					System.out.println("=====================================");
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
				System.out.println("Employee Section");
				System.out.println("================================\n");
				System.out.println("========Select your Option========\n");
				System.out.println("1. Login Your Account if you are already Regitered Employee");
				System.out.println("2. Register Yourself If you are a New Employee.");
				System.out.println("3. Stop/Exit Application.");
                
				int EmpChoice = sc.nextInt();
				if(EmpChoice==1){
					EmployeeLogIn employeeLogin = new EmployeeLogIn();
					int LoggedinEmpId = employeeLogin.loginEmployee();
                    
					while(true) {
						System.out.println("\n========Select your Option========\n");
						System.out.println("1. For Register a Complaint.");
						System.out.println("5. Logout.");
						
						int option = sc.nextInt();
						System.out.println("==========================================");
						System.out.println("Employee");
						System.out.println("===========================================");
						if(option==1) {
							System.out.println("Raise Complaint.");
							System.out.println("=======================================");
							EmployeeRaiseComplaint empComplaintTicket = new EmployeeRaiseComplaint();
							empComplaintTicket.RaiseComplaintByEmployee(LoggedinEmpId);
							System.out.println("========================================");
						}else if(option==5) {
							main(args);
						}
					}
					
				}
				
				else if(EmpChoice==2) {
					EmployeeRegistration employeeRegister = new EmployeeRegistration();
					employeeRegister.RegisterNewEmployee();
					System.out.println("============================================");
				}else if(EmpChoice==3){
					System.out.println("*****************************************");
					System.out.println("Thank you.");
					System.exit(0);
				}else {
					System.out.println("Invalid Selection. Please Try Again.");
				}
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
