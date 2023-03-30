package com.ui.Main;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.exception.ComplaintException;
import com.exception.EmployeeException;
import com.exception.NoRecordFoundException;
import com.ui.Employee.EmployeeChangePassword;
import com.ui.Employee.EmployeeCheckComplaintStatus;
import com.ui.Employee.EmployeeComplaintHistory;
import com.ui.Employee.EmployeeLogIn;
import com.ui.Employee.EmployeeRaiseComplaint;
import com.ui.Employee.EmployeeRegistration;
import com.ui.Engineer.EngineerChangePassword;
import com.ui.Engineer.EngineerCheckComplaintsAssigned;
import com.ui.Engineer.EngineerCheckComplaintsAttended;
import com.ui.Engineer.EngineerLogIn;
import com.ui.Engineer.EngineerUpdateComplaintStatus;
import com.ui.Hod.HODAddNewDepartment;
import com.ui.Hod.HODAssignComplaintToEngineer;
import com.ui.Hod.HodCheckComplaints;
import com.ui.Hod.HodCheckDepartment;
import com.ui.Hod.HodCheckEmployee;
import com.ui.Hod.HodCheckEngineersUI;
import com.ui.Hod.HodDeleteDepartment;
import com.ui.Hod.HodDeleteEmployee;
import com.ui.Hod.HodDeleteEngineer;
import com.ui.Hod.HodLogin;
import com.ui.Hod.HodRegisterEngineerUI;

public class UiMain {
	public static void main(String[] args)
			throws ClassNotFoundException, NoRecordFoundException, SQLIntegrityConstraintViolationException, EmployeeException {
		System.out.println("+------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                                                      |");
		System.out.println("|                     Welcome to Online Hardware and Software Support System                           |");
		System.out.println("|                                                                                                      |");
		System.out.println("+------------------------------------------------------------------------------------------------------+\n");
		System.out.println("+------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                       Select your Designation                                        |");
		System.out.println("+------------------------------------------------------------------------------------------------------+");
		System.out.println("|     1. HOD                                                                                           |");
		System.out.println("|     2. Employee                                                                                      |");
		System.out.println("|     3. Engineer                                                                                      |");
		System.out.println("|     4. Stop Application                                                                              |");
		System.out.println("+------------------------------------------------------------------------------------------------------+\n");
		Scanner sc = new Scanner(System.in);

		int choice = sc.nextInt();

		switch (choice) {

		case 1:
	    System.out.println("+------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                           HOD Section                                                |");
		System.out.println("+------------------------------------------------------------------------------------------------------+");
			HodLogin login = new HodLogin();
			login.LoginHOD();
			while (true) {
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				System.out.println("|                                       Select Your Option                                             |");
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				System.out.println("|     1. View all Raised Complaints                                                                    |");
				System.out.println("|     2. Assign a Complaint To an Engineer                                                             |");
				System.out.println("| (Engineer Section)                                                                                   |");
				System.out.println("|     3. Register a new Engineer                                                                       |");
				System.out.println("|     4. View Engineers List                                                                           |");
				System.out.println("|     5. Delete Engineer From Database                                                                 |");
				System.out.println("| (Department Section)                                                                                 |");
				System.out.println("|     6. Add Department In DataBase                                                                    |");
				System.out.println("|     7. View Department List                                                                          |");
				System.out.println("|     8. Delete Department From DataBase                                                               |");			
				System.out.println("| (Employee Section)                                                                                   |");
				System.out.println("|     9. Register a New Employee                                                                       |");
				System.out.println("|     10.View Employee List                                                                            |");
				System.out.println("|     11.Delete Employee From Database                                                                 |");
				System.out.println("|     12.Logout                                                                                        |");
				System.out.println("+------------------------------------------------------------------------------------------------------+");

				int hodChoice = sc.nextInt();
			

				
				if (hodChoice == 1) {
					HodCheckComplaints checkComplaints = new HodCheckComplaints();
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					System.out.println("|                                           All Complaints                                             |");
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					checkComplaints.CheckAllComplaintsByHOD();
					
				} else if (hodChoice == 2) {
					HODAssignComplaintToEngineer assignComplain = new HODAssignComplaintToEngineer();
					assignComplain.AssignComplaintToEngineer();
				
				}
				else if (hodChoice == 3) {
					HodRegisterEngineerUI reg = new HodRegisterEngineerUI();
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					System.out.println("|                                       Register a new Engineer                                        |");
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					reg.hodRegisterEngineer();
				}

				else if (hodChoice == 4) {
					HodCheckEngineersUI checkEngineersList = new HodCheckEngineersUI();
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					System.out.println("|                                           Engineers List                                             |");
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					checkEngineersList.hodCheckEngineers();
				}

				else if (hodChoice == 5) {
					HodDeleteEngineer delete = new HodDeleteEngineer();
					delete.hodDeleteEngineer();
				
				}

				else if (hodChoice == 6) {
					HODAddNewDepartment addDepartment = new HODAddNewDepartment();
					addDepartment.HodRegisterDepartment();
				}else if (hodChoice == 7) {
					HodCheckDepartment checkDepartmentList = new HodCheckDepartment();
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					System.out.println("|                                         Department List                                              |");
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					checkDepartmentList.CheckDepartmentByHOD();
					
				}else if (hodChoice == 8) {
					HodDeleteDepartment delete = new HodDeleteDepartment();
					delete.hodDeleteDepartment();
				}
				else if (hodChoice == 9) {
					EmployeeRegistration employeeRegister = new EmployeeRegistration();
					employeeRegister.RegisterNewEmployee();
					
				}else if (hodChoice == 10) {
					HodCheckEmployee checkEmployeeList = new HodCheckEmployee();
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					System.out.println("|                                         Employee List                                                |");
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					checkEmployeeList.CheckEmployeeByHOD();
					
				} else if (hodChoice == 11) {
					HodDeleteEmployee delete = new HodDeleteEmployee();
					delete.HODDeleteEmployee();
				
				}
				else if (hodChoice == 12) {
					UiMain.main(args);
				} else {
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					System.out.println("|                         Invalid choice. Please enter a correct choice                                |");
					System.out.println("+------------------------------------------------------------------------------------------------------+");
				}
			}

		case 2:
			while (true) {
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				System.out.println("|                                       Employee Section                                               |");
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				System.out.println("|                                       Select Your Option                                             |");
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				System.out.println("|     1. Login Your Employee Account                                                                   |");
				System.out.println("|     2. Go Back                                                                                       |");
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				int EmpChoice = sc.nextInt();
				if (EmpChoice == 1) {
					EmployeeLogIn employeeLogin = new EmployeeLogIn();
					int LoggedinEmpId = employeeLogin.loginEmployee();

					while (true) {
						System.out.println("+------------------------------------------------------------------------------------------------------+");
						System.out.println("|                                         Select Your Option                                           |");
						System.out.println("+------------------------------------------------------------------------------------------------------+");
						System.out.println("|     1. For Register a Complaint                                                                      |");
						System.out.println("|     2. Check Status of a Complaint                                                                   |");
						System.out.println("|     3. Check Complaint History by Employee                                                           |");
						System.out.println("|     4. Change Your Password                                                                          |");
						System.out.println("|     5. Logout                                                                                       |");
						System.out.println("+------------------------------------------------------------------------------------------------------+");
					
						int option = sc.nextInt();
					if (option == 1) {
							System.out.println("+------------------------------------------------------------------------------------------------------+");
							System.out.println("|                                       Raise Complaint                                                |");
							System.out.println("+------------------------------------------------------------------------------------------------------+");
							EmployeeRaiseComplaint empComplaintTicket = new EmployeeRaiseComplaint();
							empComplaintTicket.RaiseComplaintByEmployee(LoggedinEmpId);
							
						} else if (option == 2) {
							EmployeeCheckComplaintStatus employeeCheckStatus = new EmployeeCheckComplaintStatus();
							employeeCheckStatus.CheckComplaintStatusByEmployee();
							
						} else if (option == 3) {
							System.out.println("+------------------------------------------------------------------------------------------------------+");
							System.out.println("|                                      Complaint History                                               |");
							System.out.println("+------------------------------------------------------------------------------------------------------+");
							EmployeeComplaintHistory employeeHistory = new EmployeeComplaintHistory();
							employeeHistory.CheckComplaintHistoryOfEmployee(LoggedinEmpId);
							
						} else if (option == 4) {
							System.out.println("+------------------------------------------------------------------------------------------------------+");
							System.out.println("|                                   Change Password                                                    |");
							System.out.println("+------------------------------------------------------------------------------------------------------+");
							EmployeeChangePassword employeePasswordChange = new EmployeeChangePassword();
							employeePasswordChange.EmployeeChangePasswordUI();
						

						} else if (option == 5) {
							main(args);
						} else {
							System.out.println("+------------------------------------------------------------------------------------------------------+");
							System.out.println("|                              Oops! Invalid Option Try Again                                          |");
							System.out.println("+------------------------------------------------------------------------------------------------------+");
						}
					}

				} else if (EmpChoice == 2) {
					UiMain.main(args);
				} else {
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					System.out.println("|                                   Invalid Selection. Please Try Again                                |");
					System.out.println("+------------------------------------------------------------------------------------------------------+");
				}
			}
		case 3:
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			System.out.println("|                                          System Engineer                                             |");
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			EngineerLogIn engineerLogIn = new EngineerLogIn();
			int engIdLoggedIn = engineerLogIn.engineerLogin();

			

			while (true) {
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				System.out.println("|                                          Select your Option                                          |");
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				System.out.println("|     1. Check Complaints Assigned                                                                     |");
				System.out.println("|     2. Update complaint Status                                                                       |");
				System.out.println("|     3. View List of All the Complaints Attended                                                      |");
				System.out.println("|     4. Change Your Password                                                                          |");
				System.out.println("|     5. LogOut                                                                                        |");
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				int engChoice = sc.nextInt();
				if (engChoice == 1) {
					EngineerCheckComplaintsAssigned engineerComplaintAssign = new EngineerCheckComplaintsAssigned();
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					System.out.println("|                                       Complaints Assigned                                            |");
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					try {
						engineerComplaintAssign.checkComplaintsAssigned(engIdLoggedIn);
			
					} catch (ComplaintException e) {
						System.out.println(e.getMessage());
					}

				} else if (engChoice == 2) {
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					System.out.println("|                                      Update Complaint Status                                         |");
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					EngineerUpdateComplaintStatus engineerUpdateComplaint = new EngineerUpdateComplaintStatus();
					engineerUpdateComplaint.EngineerComplaintStatusUpdate(engIdLoggedIn);
					

				} else if (engChoice == 3) {
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					System.out.println("|                                   All complaints Attended by Engineer                                |");
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					EngineerCheckComplaintsAttended engTotalAttended = new EngineerCheckComplaintsAttended();
					engTotalAttended.CheckComplaintsAttended(engIdLoggedIn);
					

				} else if (engChoice == 4) {
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					System.out.println("|                                            Change Password                                           |");
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					EngineerChangePassword engineerChangePassword = new EngineerChangePassword();
					engineerChangePassword.EngineerPasswordChange();
					

				} else if (engChoice == 5) {
					main(args);
				} else {
					System.out.println("+------------------------------------------------------------------------------------------------------+");
					System.out.println("|                                    Invalid Selection. Please Try Again                               |");
					System.out.println("+------------------------------------------------------------------------------------------------------+");
				}
			}

		case 4:
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			System.out.println("|                                Thank you for Using Our Application                                   |");
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			System.exit(0);

		}
	}
}