package com.ui;

import java.util.List;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.dto.Complaints;
import com.dto.Department;
import com.exception.NoRecordFoundException;

public class HodCheckDepartment {
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
