package com.ui.Employee;

import java.util.List;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.dto.Complaints;
import com.exception.ComplaintException;

/**
 * 
 * The EmployeeComplaintHistory class provides a method to check the complaint
 * history of an employee
 * by using their employee ID. It calls the CheckComplaintHistoryByEmployee
 * method from the EmployeeDAOImpl
 * class to retrieve the complaint history and prints the result to the console.
 * If no complaint history is
 * found, it displays a message indicating that no complaint history was found.
 * 
 * @author HoshiyarJyani
 */
public class EmployeeComplaintHistory {
	/**
	 * Checks the complaint history of an employee by using their employee ID.
	 * 
	 * @param empId the ID of the employee whose complaint history needs to be
	 *              checked
	 * @throws ClassNotFoundException if there is an error loading the necessary
	 *                                classes
	 * @author HoshiyarJyani
	 */
	public void CheckComplaintHistoryOfEmployee(int empId) throws ClassNotFoundException {

		EmployeeDAO dao = new EmployeeDAOImpl();

		try {
			List<Complaints> complaints = dao.CheckComplaintHistoryByEmployee(empId);
			if (complaints.size() == 0) {
				System.out.println(
						"                                    No Complaint History Found                                             ");
			} else {
				complaints.forEach(x -> System.out.println(x));
			}

		} catch (ComplaintException e) {
			e.printStackTrace();
		}
	}
}
