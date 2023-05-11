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
import com.dto.Engineer;
import com.exception.ComplaintException;
import com.exception.EngineerException;
import com.exception.NoRecordFoundException;

/**
 * 
 * Implementation of the EngineerDAO interface that provides methods to interact
 * with the database for the Engineer entity.
 * 
 * @author HoshiyarJyani
 */
public class EngineerDAOImpl implements EngineerDAO {
	/**
	 * Logs in the engineer with the given username and password.
	 * 
	 * @param username The username of the engineer to log in.
	 * @param password The password of the engineer to log in.
	 * @return The Engineer object if the login is successful, null otherwise.
	 * @throws EngineerException      if there is an error while accessing the data.
	 * @throws ClassNotFoundException if the JDBC driver is not found.
	 */
	@Override
	public Engineer LogInEngineer(String username, String password) throws EngineerException, ClassNotFoundException {
		Engineer engineer = new Engineer();
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM engineer WHERE username = ? AND password = ?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				engineer.setEngId(rs.getInt("engId"));
				engineer.setName(rs.getString("name"));
				engineer.setUserName(rs.getString("username"));
				engineer.setPassword(rs.getString("password"));
				engineer.setType(rs.getString("type"));
				engineer.setLocation(rs.getString("location"));
			} else {
				throw new EngineerException("Wrong Credantials. Please Try Again.");
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
		return engineer;
	}

	/**
	 * Returns the list of complaints assigned to the engineer with the given ID.
	 * 
	 * @param engId The ID of the engineer.
	 * @return The list of Complaint objects assigned to the engineer.
	 * @throws ComplaintException if there is an error while accessing the data.
	 */
	@Override
	public List<Complaints> CheckAssignedComplaintsToEngineer(int engId) throws ComplaintException {
		List<Complaints> complaintsAssigned = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM complaints WHERE engId = ? AND status = 'Assigned'");

			ps.setInt(1, engId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Complaints comp = new Complaints();

				comp.setComplaintId(rs.getInt("complaintId"));
				comp.setEmpId(rs.getInt("empId"));
				comp.setComplaintType(rs.getString("complaintType"));
				comp.setEngId(rs.getInt("engId"));
				comp.setStatus(rs.getString("status"));
				comp.setDateRaised(rs.getDate("dateRaised"));
				comp.setDateResolved(rs.getDate("dateResolved"));

				complaintsAssigned.add(comp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return complaintsAssigned;
	}

	/**
	 * Updates the status of the complaint with the given ID and assigns it to the
	 * engineer with the given ID.
	 * 
	 * @param complaintId The ID of the complaint to update.
	 * @param newStatus   The new status of the complaint.
	 * @param engID       The ID of the engineer to assign the complaint to.
	 * @return The string "success" if the update is successful.
	 * @throws ComplaintException     if there is an error while accessing the data.
	 * @throws ClassNotFoundException if the JDBC driver is not found.
	 */
	@Override
	public String UpdateComplaintStatusByEngineer(int complaintId, String newStatus, int engID)
			throws ComplaintException, ClassNotFoundException {
		String result = "Oops! Not Found Any Complaints. Please Check Complaint-ID and Try Again.";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			int count = 0;

			if (newStatus.equals("Resolved")) {
				PreparedStatement ps = con.prepareStatement(
						"UPDATE complaints SET status = ?, dateResolved = ? WHERE complaintId = ? AND engID = ?");

				LocalDate dateResolved = LocalDate.now();

				ps.setString(1, newStatus);
				ps.setDate(2, Date.valueOf(dateResolved));
				ps.setInt(3, complaintId);
				ps.setInt(4, engID);
				count = ps.executeUpdate();

			} else {
				PreparedStatement ps = con.prepareStatement(
						"UPDATE complaints SET status = ?, dateResolved = null WHERE complaintId = ? AND engID = ?");

				ps.setString(1, newStatus);
				ps.setInt(2, complaintId);
				ps.setInt(3, engID);
				count = ps.executeUpdate();
			}

			if (count > 0) {
				result = "Status Set to " + newStatus + " for Complaint-Id : " + complaintId;
			} else {
				throw new ComplaintException(
						"Oops! Could not find complaint with Complaint-Id " + complaintId + " Please Try Again.");
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

		return result;
	}

	/**
	 * Returns the list of complaints attended by the engineer with the given ID.
	 * 
	 * @param engId The ID of the engineer.
	 * @return The list of Complaint objects attended by the engineer.
	 * @throws ComplaintException     if there is an error while accessing the data.
	 * @throws ClassNotFoundException if the JDBC driver is not found.
	 * @throws NoRecordFoundException if there are no complaints attended by the
	 *                                engineer.
	 */
	@Override
	public List<Complaints> CheckComplaintsAttendedByEngineer(int engId)
			throws ComplaintException, ClassNotFoundException, NoRecordFoundException {
		List<Complaints> list = new ArrayList<>();

		Connection con = null;

		try {
			con = DBUtils.getConnectionToDatabase();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM complaints WHERE engId = ?");

			ps.setInt(1, engId);

			ResultSet rs = ps.executeQuery();
			if (DBUtils.checkResultSet(rs)) {
				throw new NoRecordFoundException("No Complaints Found");
			}
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
	 * Changes the password of the engineer with the given username and old
	 * password.
	 * 
	 * @param userName    The username of the engineer.
	 * @param oldPassword The old password of the engineer.
	 * @param newPassword The new password to set.
	 * @return The string "success" if the password is changed successfully.
	 * @throws EngineerException      if there is an error while accessing the data.
	 * @throws ClassNotFoundException if the JDBC driver is not found.
	 */
	@Override
	public String ChangeEngineerNewPassword(String userName, String oldPassword, String newPassword)
			throws EngineerException, ClassNotFoundException {
		String result = "Password Not Changed. Please Try Again.";

		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con
					.prepareStatement("UPDATE engineer SET password = ? WHERE username = ? AND password = ?");

			ps.setString(1, newPassword);
			ps.setString(2, userName);
			ps.setString(3, oldPassword);

			int count = ps.executeUpdate();

			if (count > 0) {
				result = "Congratulations! Password Changed Successfully. Your New Password is " + newPassword;
			} else {
				throw new EngineerException("Wrong Credantials. Please TRY Again.");
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
}
