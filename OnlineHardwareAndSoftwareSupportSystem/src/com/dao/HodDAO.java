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

/**
 * 
 * The HodDAO interface specifies the methods to be implemented by classes that
 * provide
 * access to the database for operations performed by the Head of Department
 * (HOD) user.
 * This interface includes methods for:
 * Logging in an HOD user.
 * Registering a new Engineer user.
 * Retrieving a list of all Engineers.
 * Deleting an Engineer user.
 * Checking for complaints assigned to the HOD user.
 * Assigning a complaint to an Engineer user.
 * Registering a new Department.
 * Deleting a Department.
 * Deleting an Employee.
 * Checking for Departments.
 * Checking for Employees.
 * These methods can throw exceptions of types:
 * HODException: if there is an issue with the HOD user.
 * EngineerException: if there is an issue with the Engineer user.
 * ComplaintException: if there is an issue with a complaint.
 * DepartmentException: if there is an issue with a Department.
 * EmployeeException: if there is an issue with an Employee.
 * ClassNotFoundException: if there is an issue with the class or classloader.
 * NoRecordFoundException: if there are no records found for a given operation.
 * 
 * @author HoshiyarJyani
 */
public interface HodDAO {
	/**
	 * Attempts to log in a Head of Department with the specified username and
	 * password.
	 * 
	 * @param username The username of the Head of Department.
	 * @param password The password of the Head of Department.
	 * @return The HOD object if the login is successful.
	 * @throws HODException           If there is an error with the HOD object.
	 * @throws ClassNotFoundException If the class cannot be found.
	 */
	public HOD loginHodDAO(String username, String password) throws HODException, ClassNotFoundException;

	/**
	 * Registers a new engineer with the given name, username, password, type, and
	 * location.
	 * 
	 * @param name     The name of the new engineer.
	 * @param username The username of the new engineer.
	 * @param password The password of the new engineer.
	 * @param type     The type of the new engineer.
	 * @param location The location of the new engineer.
	 * @return A string indicating whether the registration was successful or not.
	 * @throws EngineerException      If there is an error with the Engineer object.
	 * @throws ClassNotFoundException If the class cannot be found.
	 */
	public String registerEngineer(String name, String username, String password, String type, String location)
			throws EngineerException, ClassNotFoundException;

	/**
	 * Retrieves a list of all engineers.
	 * 
	 * @return A list of all Engineer objects.
	 * @throws EngineerException      If there is an error with the Engineer object.
	 * @throws ClassNotFoundException If the class cannot be found.
	 * @throws NoRecordFoundException If there are no records found.
	 */
	public List<Engineer> getEngineers() throws EngineerException, ClassNotFoundException, NoRecordFoundException;

	/**
	 * Deletes an engineer with the given ID.
	 * 
	 * @param engId The ID of the engineer to delete.
	 * @return A string indicating whether the deletion was successful or not.
	 * @throws EngineerException      If there is an error with the Engineer object.
	 * @throws ClassNotFoundException If the class cannot be found.
	 */
	public String DeleteEngineerByHodDAO(int engId) throws EngineerException, ClassNotFoundException;

	/**
	 * Retrieves a list of all complaints.
	 * 
	 * @return A list of all Complaint objects.
	 * @throws ComplaintException     If there is an error with the Complaint
	 *                                object.
	 * @throws ClassNotFoundException If the class cannot be found.
	 * @throws NoRecordFoundException If there are no records found.
	 */
	public List<Complaints> CheckComplaintsByHodDAO()
			throws ComplaintException, ClassNotFoundException, NoRecordFoundException;

	/**
	 * Assigns a complaint with the given ID to an engineer with the given ID.
	 * 
	 * @param complaintId The ID of the complaint to assign.
	 * @param engineerId  The ID of the engineer to assign the complaint to.
	 * @return A string indicating whether the assignment was successful or not.
	 * @throws EngineerException      If there is an error with the Engineer object.
	 * @throws ClassNotFoundException If the class cannot be found.
	 */
	public String AssignComplaintToEngineerByHOD(int complaintId, int engineerId)
			throws EngineerException, ClassNotFoundException;

	/**
	 * Registers a new department with the given name and location.
	 * 
	 * @param dname    The name of the new department.
	 * @param location The location of the new department.
	 * @return A string indicating whether the registration was successful or not.
	 * @throws ClassNotFoundException If the class cannot be found.
	 * @throws DepartmentException    If there is an error with the Department
	 *                                object.
	 */
	public String RegisterDepartment(String dname, String location) throws ClassNotFoundException, DepartmentException;

	/**
	 * 
	 * Deletes the department with the given name from the database.
	 * 
	 * @param dname The name of the department to be deleted.
	 * @return A String indicating the status of the deletion operation.
	 * @throws DepartmentException    if there is an error deleting the department.
	 * @throws ClassNotFoundException if the Department class is not found.
	 */
	public String DeleteDepartmentByHOD(String dname) throws DepartmentException, ClassNotFoundException;

	/**
	 * 
	 * Deletes the employee with the given ID from the database.
	 * 
	 * @param employeeId The ID of the employee to be deleted.
	 * @return A String indicating the status of the deletion operation.
	 * @throws EmployeeException      if there is an error deleting the employee.
	 * @throws ClassNotFoundException if the Employee class is not found.
	 */
	public String DeleteEmployeeByHodDAO(int employeeId) throws EmployeeException, ClassNotFoundException;

	/**
	 * 
	 * Retrieves a list of all departments from the database.
	 * 
	 * @return A List of Department objects.
	 * @throws ClassNotFoundException if the Department class is not found.
	 * @throws NoRecordFoundException if there are no records found in the database.
	 */
	public List<Department> CheckDepartmentByHodDAO() throws ClassNotFoundException, NoRecordFoundException;

	/**
	 * 
	 * Retrieves a list of all employees from the database.
	 * 
	 * @return A List of Employee objects.
	 * @throws ClassNotFoundException if the Employee class is not found.
	 * @throws NoRecordFoundException if there are no records found in the database.
	 */
	public List<Employee> CheckEmployeeByHodDAO() throws ClassNotFoundException, NoRecordFoundException;
}