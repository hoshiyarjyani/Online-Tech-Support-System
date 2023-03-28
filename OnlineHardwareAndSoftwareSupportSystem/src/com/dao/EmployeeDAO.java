package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.Complaints;
import com.dto.Employee;
import com.dto.EngineerComplaintsDTO;
import com.exception.ComplaintException;
import com.exception.EmployeeException;

public interface EmployeeDAO {
	public String RegisterEmployee(int deptid, String name, String username, String password) throws EmployeeException, ClassNotFoundException, SQLException;

	public Employee LoginEmployee(String username, String password) throws EmployeeException, ClassNotFoundException;

	public int RaiseComplaintByTheEmployee(int empId, String complaintType) throws ComplaintException, ClassNotFoundException;

	public EngineerComplaintsDTO CheckComplaintStatusByEmployee(int complaintId) throws ComplaintException, ClassNotFoundException;

	public List<Complaints> CheckComplaintHistoryByEmployee(int empId) throws ComplaintException, ClassNotFoundException;

	public String ChangeEmployeePassword(String username, String oldPassword, String newPassword) throws EmployeeException, ClassNotFoundException;

}
