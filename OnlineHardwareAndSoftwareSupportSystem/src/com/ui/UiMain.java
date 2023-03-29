package com.ui;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.exception.ComplaintException;
import com.exception.EmployeeException;
import com.exception.NoRecordFoundException;

public class UiMain {
	public static void main(String[] args)
			throws ClassNotFoundException, NoRecordFoundException, SQLIntegrityConstraintViolationException, EmployeeException {
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
				System.out.println("Enter 3 : Delete Engineer From Database.");
				
				System.out.println("Enter 4 : View all Raised Complaints");
				System.out.println("Enter 5 : Assign a Complaint To an Engineer.");
				
				System.out.println("Enter 6 : Add Department In DataBase");
				System.out.println("Enter 9 : Delete Department From DataBase");
				System.out.println("Enter 7 : Register a New Employee");
				System.out.println("Enter 10: Delete Employee From Database");
				System.out.println("Enter 8 : Logout");

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
				} else if (hodChoice == 5) {
					HODAssignComplaintToEngineer assignComplain = new HODAssignComplaintToEngineer();
					assignComplain.AssignComplaintToEngineer();
					System.out.println("=====================================");
				}else if (hodChoice == 6) {
					HODAddNewDepartment addDepartment = new HODAddNewDepartment();
					addDepartment.HodRegisterDepartment();
					System.out.println("=====================================");
				} else if (hodChoice == 7) {
					EmployeeRegistration employeeRegister = new EmployeeRegistration();
					employeeRegister.RegisterNewEmployee();
					System.out.println("============================================");
				} else if (hodChoice == 8) {
					UiMain.main(args);
				}else if (hodChoice == 9) {
					HodDeleteDepartment delete = new HodDeleteDepartment();
					delete.hodDeleteDepartment();
					System.out.println("====================================");
				}else if (hodChoice == 10) {
					HodDeleteEmployee delete = new HodDeleteEmployee();
					delete.HODDeleteEmployee();
					System.out.println("====================================");
				} else {
					System.out.println("Invalid choice. Please enter a correct choice.");
					System.out.println("====================================================");
				}
			}

		case 2:
			while (true) {
				System.out.println("Employee Section");
				System.out.println("================================\n");
				System.out.println("========Select your Option========\n");
				System.out.println("1. Login Your Employee Account");
				System.out.println("2. Stop/Exit Application.");

				int EmpChoice = sc.nextInt();
				if (EmpChoice == 1) {
					EmployeeLogIn employeeLogin = new EmployeeLogIn();
					int LoggedinEmpId = employeeLogin.loginEmployee();

					while (true) {
						System.out.println("\n========Select your Option========\n");
						System.out.println("1. For Register a Complaint.");
						System.out.println("2. Check Status of a Complaint.");
						System.out.println("3. Check Complaint History by Employee.");
						System.out.println("4. Change Your Password.");
						System.out.println("5. Logout.");

						int option = sc.nextInt();
						System.out.println("==========================================");
						System.out.println("Employee");
						System.out.println("===========================================");
						if (option == 1) {
							System.out.println("Raise Complaint");
							System.out.println("=======================================");
							EmployeeRaiseComplaint empComplaintTicket = new EmployeeRaiseComplaint();
							empComplaintTicket.RaiseComplaintByEmployee(LoggedinEmpId);
							System.out.println("========================================");
						} else if (option == 2) {
							EmployeeCheckComplaintStatus employeeCheckStatus = new EmployeeCheckComplaintStatus();
							employeeCheckStatus.CheckComplaintStatusByEmployee();
							System.out.println("==========================================");
						} else if (option == 3) {
							System.out.println("Complaint History");
							System.out.println("============================================");
							EmployeeComplaintHistory employeeHistory = new EmployeeComplaintHistory();
							employeeHistory.CheckComplaintHistoryOfEmployee(LoggedinEmpId);
							System.out.println("=============================================");
						} else if (option == 4) {
							System.out.println("Change Password.");
							System.out.println("=============================================");
							EmployeeChangePassword employeePasswordChange = new EmployeeChangePassword();
							employeePasswordChange.EmployeeChangePasswordUI();
							System.out.println("=============================================");

						} else if (option == 5) {
							main(args);
						} else {
							System.out.println("Oops! Invalid Option Try Again");
						}
					}

				} else if (EmpChoice == 2) {
					System.out.println("*****************************************");
					System.out.println("Thank you.");
					System.exit(0);
				} else {
					System.out.println("Invalid Selection. Please Try Again.");
				}
			}
		case 3:
			System.out.println("System Engineer");
			System.out.println("==================================================");
			EngineerLogIn engineerLogIn = new EngineerLogIn();
			int engIdLoggedIn = engineerLogIn.engineerLogin();

			System.out.println("==================================================");

			while (true) {
				System.out.println("\n========Select your Option========\n");
				System.out.println("1. Check Complaints Assigned.");
				System.out.println("2. Update complaint Status.");
				System.out.println("3. View List of All the Complaints Attended.");
				System.out.println("4. Change Your Password.");
				System.out.println("5. Logout/Exit.");

				int engChoice = sc.nextInt();
				if (engChoice == 1) {
					EngineerCheckComplaintsAssigned engineerComplaintAssign = new EngineerCheckComplaintsAssigned();
					System.out.println("Complaints Assigned.");
					System.out.println("==============================================");
					try {
						engineerComplaintAssign.checkComplaintsAssigned(engIdLoggedIn);
						System.out.println("==========================================");
					} catch (ComplaintException e) {
						System.out.println(e.getMessage());
					}

				} else if (engChoice == 2) {
					System.out.println("Update Complaint Status");
					System.out.println("==============================================");
					EngineerUpdateComplaintStatus engineerUpdateComplaint = new EngineerUpdateComplaintStatus();
					engineerUpdateComplaint.EngineerComplaintStatusUpdate(engIdLoggedIn);
					System.out.println("==============================================");

				} else if (engChoice == 3) {
					System.out.println("All complaints Attended by Engineer.");
					System.out.println("================================================");
					EngineerCheckComplaintsAttended engTotalAttended = new EngineerCheckComplaintsAttended();
					engTotalAttended.CheckComplaintsAttended(engIdLoggedIn);
					System.out.println("=================================================");

				} else if (engChoice == 4) {
					System.out.println("Change Password.");
					System.out.println("=================================================");
					EngineerChangePassword engineerChangePassword = new EngineerChangePassword();
					engineerChangePassword.EngineerPasswordChange();
					System.out.println("==================================================");

				} else if (engChoice == 5) {
					main(args);
				} else {
					System.out.println("Invalid Selection. Please Try Again.");
				}
			}

		case 4:
			System.out.println("Thank you.");
			System.exit(0);

		}
	}
}
