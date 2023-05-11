package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * The HodDAOImpl class provides the implementation for the HodDAO interface.
 * It defines methods to interact with the database and perform CRUD operations
 * on
 * Department, Employee, Engineer, and Complaints entities.
 * This class implements the following methods:
 * 
 * @see HodDAO#loginHodDAO(String, String)
 * @see HodDAO#registerEngineer(String, String, String, String, String)
 * @see HodDAO#getEngineers()
 * @see HodDAO#DeleteEngineerByHodDAO(int)
 * @see HodDAO#CheckComplaintsByHodDAO()
 * @see HodDAO#AssignComplaintToEngineerByHOD(int, int)
 * @see HodDAO#RegisterDepartment(String, String)
 * @see HodDAO#DeleteDepartmentByHOD(String)
 * @see HodDAO#DeleteEmployeeByHodDAO(int)
 * @see HodDAO#CheckDepartmentByHodDAO()
 * @see HodDAO#CheckEmployeeByHodDAO()
 * @author HoshiyarJyani
 */
public class HodDAOImpl implements HodDAO {

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
	@Override
	public HOD loginHodDAO(String username, String password) throws HODException, ClassNotFoundException {
		Connection con = null;
		HOD hod = new HOD();
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM hod WHERE username = ? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				hod.setHodId(rs.getInt("hodId"));
				hod.setName(rs.getString("name"));
				hod.setUserName(rs.getString("username"));
				hod.setPassword(rs.getString("password"));
			} else {
				throw new HODException("Invalid Username or Password.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new HODException(e.getMessage());
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hod;
	}

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
	@Override
	public String registerEngineer(String name, String username, String password, String type, String location)
			throws EngineerException, ClassNotFoundException {
		String res = "";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO Engineer (name,username,password,type,location) values(?,?,?,?,?)");

			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, type);
			ps.setString(5, location);

			int x = ps.executeUpdate();
			if (x > 0) {
				res = "Engineer Registered Sucessfully. Username of Engineer is [ " + username + " ] and Password is [ "
						+ password + " ].";
				;
			} else {
				throw new EngineerException("Invalid Entries. Please Try Again Later.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
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
	 * Retrieves a list of all engineers.
	 * 
	 * @return A list of all Engineer objects.
	 * @throws EngineerException      If there is an error with the Engineer object.
	 * @throws ClassNotFoundException If the class cannot be found.
	 * @throws NoRecordFoundException If there are no records found.
	 */
	@Override
	public List<Engineer> getEngineers() throws EngineerException, ClassNotFoundException, NoRecordFoundException {
		List<Engineer> list = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM engineer");

			ResultSet rs = ps.executeQuery();
			if (DBUtils.checkResultSet(rs)) {
				throw new NoRecordFoundException("No Engineers found");
			}
			while (rs.next()) {
				Engineer eng = new Engineer();

				eng.setEngId(rs.getInt("engId"));
				eng.setName(rs.getString("name"));
				eng.setUserName(rs.getString("username"));
				eng.setPassword(rs.getString("password"));
				eng.setType(rs.getString("type"));
				eng.setLocation(rs.getString("location"));

				list.add(eng);

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
	 * Deletes an engineer with the given ID.
	 * 
	 * @param engId The ID of the engineer to delete.
	 * @return A string indicating whether the deletion was successful or not.
	 * @throws EngineerException      If there is an error with the Engineer object.
	 * @throws ClassNotFoundException If the class cannot be found.
	 */
	@Override
	public String DeleteEngineerByHodDAO(int engineerId) throws EngineerException, ClassNotFoundException {
		Connection con = null;
		String result = "Engineer not present in Record who's ID is " + engineerId;

		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("DELETE FROM engineer WHERE engId = ?");

			ps.setInt(1, engineerId);

			int x = ps.executeUpdate();

			if (x > 0) {
				result = "Engineer who's ID is " + engineerId + " is Sucessfully Deleted from Database.";
			} else {
				throw new EngineerException("Engineer Who's ID " + engineerId + " is not Found in Records.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * Retrieves a list of all complaints.
	 * 
	 * @return A list of all Complaint objects.
	 * @throws ComplaintException     If there is an error with the Complaint
	 *                                object.
	 * @throws ClassNotFoundException If the class cannot be found.
	 * @throws NoRecordFoundException If there are no records found.
	 */
	@Override
	public List<Complaints> CheckComplaintsByHodDAO()
			throws ComplaintException, ClassNotFoundException, NoRecordFoundException {
		List<Complaints> list = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM complaints WHERE status = 'Raised'");

			ResultSet rs = ps.executeQuery();
			if (DBUtils.checkResultSet(rs)) {
				throw new NoRecordFoundException("No Complaint found");
			}
			while (rs.next()) {
				Complaints complaint = new Complaints();

				complaint.setComplaintId(rs.getInt("complaintId"));
				complaint.setEmpId(rs.getInt("empId"));
				complaint.setComplaintType(rs.getString("complaintType"));
				complaint.setEngId(rs.getInt("engId"));
				complaint.setDateRaised(rs.getDate("dateRaised"));
				complaint.setDateResolved(rs.getDate("dateResolved"));
				complaint.setStatus(rs.getString("status"));

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
	 * Assigns a complaint with the given ID to an engineer with the given ID.
	 * 
	 * @param complaintId The ID of the complaint to assign.
	 * @param engineerId  The ID of the engineer to assign the complaint to.
	 * @return A string indicating whether the assignment was successful or not.
	 * @throws EngineerException      If there is an error with the Engineer object.
	 * @throws ClassNotFoundException If the class cannot be found.
	 */
	@Override
	public String AssignComplaintToEngineerByHOD(int complaintId, int engineerId)
			throws EngineerException, ClassNotFoundException {
		String result = "Complaint-Id Not Found in Database. Please Enter a Valid Complaint-Id.";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con
					.prepareStatement("UPDATE complaints SET engId = ?, status = 'Assigned' where complaintId = ?");

			ps.setInt(1, engineerId);
			ps.setInt(2, complaintId);

			int count = ps.executeUpdate();
			if (count > 0) {
				result = "Complaint with ID " + complaintId + " Assigned to Engineer who's ID is " + engineerId;
			} else {
				throw new EngineerException("Engineer or Complaint Not Found In Records.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
		}

		return result;
	}

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
	@Override
	public String RegisterDepartment(String dname, String location) throws ClassNotFoundException, DepartmentException {
		String result = "";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("INSERT INTO department (dname,location) values(?,?)");

			ps.setString(1, dname);
			ps.setString(2, location);

			int x = ps.executeUpdate();
			if (x > 0) {
				result = "Department Registered Sucessfully. The Name Of Department is " + dname;
			} else {
				throw new DepartmentException("Invalid Entries. Please Try Again Later.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DepartmentException(e.getMessage());
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 
	 * Deletes the department with the given name from the database.
	 * 
	 * @param dname The name of the department to be deleted.
	 * @return A String indicating the status of the deletion operation.
	 * @throws DepartmentException    if there is an error deleting the department.
	 * @throws ClassNotFoundException if the Department class is not found.
	 */
	@Override
	public String DeleteDepartmentByHOD(String dname) throws DepartmentException, ClassNotFoundException {
		Connection con = null;
		String result = "Department not present in Record who's Name is " + dname;

		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("DELETE FROM department WHERE dname = ?");

			ps.setString(1, dname);

			int x = ps.executeUpdate();

			if (x > 0) {
				result = "Department " + dname + " is Sucessfully Deleted from Database.";
			} else {
				throw new DepartmentException("Department " + dname + " is not Found in Records.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DepartmentException(e.getMessage());
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 
	 * Deletes the employee with the given ID from the database.
	 * 
	 * @param employeeId The ID of the employee to be deleted.
	 * @return A String indicating the status of the deletion operation.
	 * @throws EmployeeException      if there is an error deleting the employee.
	 * @throws ClassNotFoundException if the Employee class is not found.
	 */
	@Override
	public String DeleteEmployeeByHodDAO(int employeeId) throws EmployeeException, ClassNotFoundException {
		Connection con = null;
		String result = "Employee Not Present in Record who's ID is " + employeeId;

		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE EmpId = ?");

			ps.setInt(1, employeeId);

			int x = ps.executeUpdate();

			if (x > 0) {
				result = "Employee who's ID is " + employeeId + " is Sucessfully Deleted from Database.";
			} else {
				throw new EmployeeException("Employee Who's ID " + employeeId + " is not Found in Records.");
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

	/**
	 * 
	 * Retrieves a list of all departments from the database.
	 * 
	 * @return A List of Department objects.
	 * @throws ClassNotFoundException if the Department class is not found.
	 * @throws NoRecordFoundException if there are no records found in the database.
	 */
	@Override
	public List<Department> CheckDepartmentByHodDAO() throws ClassNotFoundException, NoRecordFoundException {
		List<Department> list = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM department");

			ResultSet rs = ps.executeQuery();
			if (DBUtils.checkResultSet(rs)) {
				throw new NoRecordFoundException("No Department found");
			}

			while (rs.next()) {
				Department department = new Department();
				department.setDeptid(rs.getInt("deptid"));
				department.setDname(rs.getString("dname"));
				department.setLocation(rs.getString("location"));

				list.add(department);
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
	 * Retrieves a list of all employees from the database.
	 * 
	 * @return A List of Employee objects.
	 * @throws ClassNotFoundException if the Employee class is not found.
	 * @throws NoRecordFoundException if there are no records found in the database.
	 */
	@Override
	public List<Employee> CheckEmployeeByHodDAO() throws ClassNotFoundException, NoRecordFoundException {
		List<Employee> list = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM employee");

			ResultSet rs = ps.executeQuery();
			if (DBUtils.checkResultSet(rs)) {
				throw new NoRecordFoundException("No Employee found");
			}

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt("EmpId"));
				employee.setDeptid(rs.getInt("deptid"));
				employee.setName(rs.getString("name"));
				employee.setUserName(rs.getString("username"));
				employee.setPassword(rs.getString("password"));

				list.add(employee);
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

}
