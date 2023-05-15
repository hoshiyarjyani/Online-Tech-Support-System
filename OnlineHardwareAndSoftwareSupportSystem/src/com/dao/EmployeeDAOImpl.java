package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dto.Complaints;
import com.dto.Employee;
import com.dto.EngineerComplaintsDTO;
import com.exception.ComplaintException;
import com.exception.EmployeeException;

/**
 * 
 * The EmployeeDAOImpl class implements the EmployeeDAO interface and provides
 * the implementation of all its methods.
 * This class performs CRUD operations on the Employee table and Complaint table
 * in the database.
 * 
 * @author HoshiyarJyani
 */
public class EmployeeDAOImpl implements EmployeeDAO {

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
	@Override
	public String RegisterEmployee(int deptid, String name, String username, String password)
			throws EmployeeException, ClassNotFoundException, SQLException {
		String res = "Oops! Your Details That You Entered Are Incorrect. Please Try Again!";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO employee (deptid,name,username,password) VALUES (?,?,?,?)");
			ps.setInt(1, deptid);
			ps.setString(2, name);
			ps.setString(3, username);
			ps.setString(4, password);

			try {
				int count = ps.executeUpdate();
				if (count > 0) {
					res = name + " Registration Successfull. The Username is [ " + username
							+ " ] and Your Password is [ " + password + " ]";
				} else {
					throw new EmployeeException("Registration Failed. Some Entries May be Incorrect.");
				}
			} catch (SQLException e) {
				String message = "An Error Occurred while Registering the Employee. Please Try Again With Valid Department ID.";
				throw new EmployeeException(message);
			}
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	/**
	 * Logs in an employee with the provided username and password.
	 * 
	 * @param username The username of the employee.
	 * @param password The password of the employee's account.
	 * @return An Employee object representing the employee that logged in.
	 * @throws EmployeeException      If there was an error while logging in.
	 * @throws ClassNotFoundException If the database driver class was not found.
	 */
	@Override
	public Employee LoginEmployee(String username, String password) throws EmployeeException, ClassNotFoundException {
		Employee employee = new Employee();
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE username = ? AND password = ?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employee.setEmpId(rs.getInt("empId"));
				employee.setDeptid(rs.getInt("deptId"));
				employee.setName(rs.getString("name"));
				employee.setUserName(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
			} else {
				throw new EmployeeException("Invalid Username or Password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employee;
	}

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
	@Override
	public int RaiseComplaintByTheEmployee(int empId, String complaintType)
			throws ComplaintException, ClassNotFoundException {
		int complaintId = 0;
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO complaints (complaintId,empId,complaintType,status,dateRaised) values(?,?,?,?,?)");

			complaintId = (int) (Math.random() * 10000);
			LocalDate dateRaised = LocalDate.now();
			ps.setInt(1, complaintId);
			ps.setInt(2, empId);
			ps.setString(3, complaintType);
			ps.setString(4, "Raised");
			ps.setDate(5, Date.valueOf(dateRaised));

			int num = ps.executeUpdate();

			if (num > 0) {
				System.out.println("Complaint Raised Successfully\nYour Complaint No. is " + complaintId);
			} else {
				throw new ComplaintException("Oops! Complaint could Not be Raised. Please Try Again.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ComplaintException(e.getMessage());
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return complaintId;
	}

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
	@Override
	public EngineerComplaintsDTO CheckComplaintStatusByEmployee(int complaintId)
			throws ComplaintException, ClassNotFoundException {

		EngineerComplaintsDTO complaindto = new EngineerComplaintsDTO();
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement(
					"SELECT c.complaintId, c.engId, e.name,c.complaintType, c.status, c.dateRaised FROM complaints c INNER JOIN engineer e ON c.engId = e.engId WHERE complaintId = ?");
			ps.setInt(1, complaintId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				complaindto.setComplaintId(rs.getInt("complaintId"));
				complaindto.setComplaintType(rs.getString("complaintType"));
				complaindto.setEngId(rs.getInt("engId"));
				complaindto.setName(rs.getString("name"));
				complaindto.setStatus(rs.getString("status"));
				complaindto.setDateRaised(rs.getDate("dateRaised"));
			} else {
				throw new ComplaintException(
						"Complaint Not Assigned Yet or No Complaint Found In Record. Please Check After Sometime.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ComplaintException(e.getMessage());
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return complaindto;
	}

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
	@Override
	public List<Complaints> CheckComplaintHistoryByEmployee(int empId)
			throws ComplaintException, ClassNotFoundException {
		List<Complaints> list = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM complaints WHERE empId = ?");

			ps.setInt(1, empId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Complaints complaint = new Complaints();
				complaint.setComplaintId(rs.getInt("complaintId"));
				complaint.setEmpId(rs.getInt("empId"));
				complaint.setComplaintType(rs.getString("complaintType"));
				complaint.setEngId(rs.getInt("engId"));
				complaint.setStatus(rs.getString("status"));
				complaint.setDateRaised(rs.getDate("dateRaised"));
				complaint.setDateResolved(rs.getDate("dateResolved"));

				list.add(complaint);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

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
	@Override
	public String ChangeEmployeePassword(String username, String oldPassword, String newPassword)
			throws EmployeeException, ClassNotFoundException {
		String result = "Password Not Changed. Please Try Again.";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con
					.prepareStatement("UPDATE employee SET password = ? WHERE username = ? AND password = ?");

			ps.setString(1, newPassword);
			ps.setString(2, username);
			ps.setString(3, oldPassword);

			int count = ps.executeUpdate();

			if (count > 0) {
				result = "Congratulations! Your Password Changed Successfully. Your New Password is [ " + newPassword
						+ " ]";
			} else {
				throw new EmployeeException("Wrong Credentials Entered. Please Try Again.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
