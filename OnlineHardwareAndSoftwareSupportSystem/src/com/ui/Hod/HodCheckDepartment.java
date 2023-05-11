package com.ui.Hod;

import java.util.List;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.dto.Department;
import com.exception.NoRecordFoundException;

/**
 * 
 * A class representing the UI for the HOD to check all the departments in the
 * database.
 * The HOD can use this class to retrieve all departments and display them.
 * 
 * @author HoshiyarJyani
 */
public class HodCheckDepartment {
	/**
	 * Retrieves all departments from the database and displays them to the HOD.
	 * 
	 * @author HoshiyarJyani
	 */
	public void CheckDepartmentByHOD() {
		try {
			HodDAO dao = new HodDAOImpl();
			List<Department> list = dao.CheckDepartmentByHodDAO();
			for (Department d : list) {
				System.out.println(d);
			}
		} catch (NoRecordFoundException e) {
			System.out.println("No Department Found.");
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}
}
