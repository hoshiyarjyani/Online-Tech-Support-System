package com.ui.Hod;

import java.util.List;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.dto.Employee;
import com.exception.NoRecordFoundException;

public class HodCheckEmployee {
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
