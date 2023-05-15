package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.Complaints;
import com.dto.Employee;
import com.dto.EngineerComplaintsDTO;
import com.exception.ComplaintException;
import com.exception.EmployeeException;

/**
 * 
 * The EmployeeDAO interface provides the method signatures for interacting with
 * the employee related data in the database.
 * 
 * @author HoshiyarJyani
 */
public interface EmployeeDAO {
	/**
	 * Registers a new employee into the database with the provided details.
	 * 
	 * @param deptid   The id of the department in which the employee belongs to.
	 * @param name     The name of the employee.
	 * @param username The unique username for the employee.
	 * @param password The password for the employee's account.
	 * @return A string indicating whether the operation was successful or not.
	 * @throws EmployeeException      If there was an error while registering the
	 *                                employee.
	 * @throws ClassNotFoundException If the database driver class was not found.
	 * @throws SQLException           If an error occurred while communicating with
	 *                                the database.
	 */
	public String RegisterEmployee(int deptid, String name, String username, String password)
			throws EmployeeException, ClassNotFoundException, SQLException;

	/**
	 * Logs in an employee with the provided username and password.
	 * 
	 * @param username The username of the employee.
	 * @param password The password of the employee's account.
	 * @return An Employee object representing the employee that logged in.
	 * @throws EmployeeException      If there was an error while logging in.
	 * @throws ClassNotFoundException If the database driver class was not found.
	 */
	public Employee LoginEmployee(String username, String password) throws EmployeeException, ClassNotFoundException;

	/**
	 * Raises a new complaint by the employee with the provided complaint type.
	 * 
	 * @param empId         The id of the employee who is raising the complaint.
	 * @param complaintType The type of the complaint being raised.
	 * @return The id of the new complaint that was raised.
	 * @throws ComplaintException     If there was an error while raising the
	 *                                complaint.
	 * @throws ClassNotFoundException If the database driver class was not found.
	 */
	public int RaiseComplaintByTheEmployee(int empId, String complaintType)
			throws ComplaintException, ClassNotFoundException;

	/**
	 * Checks the status of a complaint with the provided id.
	 * 
	 * @param complaintId The id of the complaint whose status is to be checked.
	 * @return An EngineerComplaintsDTO object containing the complaint details and
	 *         status.
	 * @throws ComplaintException     If there was an error while checking the
	 *                                complaint status.
	 * @throws ClassNotFoundException If the database driver class was not found.
	 */
	public EngineerComplaintsDTO CheckComplaintStatusByEmployee(int complaintId)
			throws ComplaintException, ClassNotFoundException;

	/**
	 * Gets the complaint history of an employee with the provided id.
	 * 
	 * @param empId The id of the employee whose complaint history is to be
	 *              retrieved.
	 * @return A list of Complaints objects representing the employee's complaint
	 *         history.
	 * @throws ComplaintException     If there was an error while retrieving the
	 *                                complaint history.
	 * @throws ClassNotFoundException If the database driver class was not found.
	 */
	public List<Complaints> CheckComplaintHistoryByEmployee(int empId)
			throws ComplaintException, ClassNotFoundException;

	/**
	 * 
	 * Changes the password for an Employee with the given username and old password
	 * to the new password.
	 * 
	 * @param username    The username of the Employee whose password is being
	 *                    changed.
	 * @param oldPassword The old password of the Employee whose password is being
	 *                    changed.
	 * @param newPassword The new password that will be set for the Employee.
	 * @return A string indicating if the password change was successful or not.
	 * @throws EmployeeException      if there was an error updating the employee's
	 *                                password in the database.
	 * @throws ClassNotFoundException if the JDBC driver class is not found.
	 */
	public String ChangeEmployeePassword(String username, String oldPassword, String newPassword)
			throws EmployeeException, ClassNotFoundException;

}
