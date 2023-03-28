package com.dao;

import java.sql.SQLException;

import com.dto.Employee;
import com.exception.EmployeeException;

public interface EmployeeDAO {
	public String RegisterEmployee(int deptid, String name, String username, String password) throws EmployeeException, ClassNotFoundException, SQLException;

	public Employee LoginEmployee(String username, String password) throws EmployeeException, ClassNotFoundException;

}