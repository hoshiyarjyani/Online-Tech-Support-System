package com.ui;

import java.util.List;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.dto.Complaints;
import com.exception.ComplaintException;

public class EmployeeComplaintHistory {

	public void CheckComplaintHistoryOfEmployee(int empId) throws ClassNotFoundException {
		
		EmployeeDAO dao = new EmployeeDAOImpl();
		
		try {
			List<Complaints> complaints = dao.CheckComplaintHistoryByEmployee(empId);
			complaints.forEach(x -> System.out.println(x));
		} catch (ComplaintException e) {
			e.printStackTrace();
		}
	}
}
