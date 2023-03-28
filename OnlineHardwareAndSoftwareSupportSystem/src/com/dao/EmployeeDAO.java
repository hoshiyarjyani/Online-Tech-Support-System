package com.dao;

import java.sql.SQLException;

import com.exception.EmployeeException;

public interface EmployeeDAO {
	public String RegisterEmployee(int deptid, String name, String username, String password) throws EmployeeException, ClassNotFoundException, SQLException;

}
