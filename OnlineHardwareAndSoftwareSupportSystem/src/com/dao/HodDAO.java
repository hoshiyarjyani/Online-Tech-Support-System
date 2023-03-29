package com.dao;

import java.util.List;

import com.dto.Complaints;
import com.dto.Department;
import com.dto.Employee;
import com.dto.Engineer;
import com.dto.HOD;
import com.exception.ComplaintException;
import com.exception.DepartmentException;
import com.exception.EmployeeException;
import com.exception.EngineerException;
import com.exception.HODException;
import com.exception.NoRecordFoundException;

public interface HodDAO {

	public HOD loginHodDAO(String username, String password) throws HODException, ClassNotFoundException;

	public String registerEngineer(String name, String username, String password, String type, String location)
			throws EngineerException, ClassNotFoundException;

	public List<Engineer> getEngineers() throws EngineerException, ClassNotFoundException, NoRecordFoundException;

	public String DeleteEngineerByHodDAO(int engId) throws EngineerException, ClassNotFoundException;

	public List<Complaints> CheckComplaintsByHodDAO()
			throws ComplaintException, ClassNotFoundException, NoRecordFoundException;

	public String AssignComplaintToEngineerByHOD(int complaintId, int engineerId)
			throws EngineerException, ClassNotFoundException;

	public String RegisterDepartment(String dname, String location) throws ClassNotFoundException, DepartmentException;

	public String DeleteDepartmentByHOD(String dname) throws DepartmentException, ClassNotFoundException;

	public String DeleteEmployeeByHodDAO(int employeeId) throws EmployeeException, ClassNotFoundException;

	public List<Department> CheckDepartmentByHodDAO() throws ClassNotFoundException, NoRecordFoundException;

	public List<Employee> CheckEmployeeByHodDAO() throws ClassNotFoundException, NoRecordFoundException;
}