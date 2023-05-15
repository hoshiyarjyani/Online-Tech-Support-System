package com.ui.Hod;

import java.util.List;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.dto.Employee;
import com.exception.NoRecordFoundException;

/**
 * 
 * This class represents the user interface for checking employees by HOD.
 * It allows the HOD to view a list of all employees in the database.
 * 
 * @author HoshiyarJyani
 */
public class HodCheckEmployee {
	/**
	 * This method retrieves a list of all employees from the database and prints it to the console.
	 * If no records are found, an appropriate message is displayed.
	 *  @author HoshiyarJyani
	 */
	public void CheckEmployeeByHOD() {
		try {
			HodDAO dao = new HodDAOImpl();
			List<Employee> list = dao.CheckEmployeeByHodDAO();
			for (Employee e : list) {
				System.out.println(e);
			}
		} catch (NoRecordFoundException e) {
			System.out.println("No Employee Found.");
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}
}
