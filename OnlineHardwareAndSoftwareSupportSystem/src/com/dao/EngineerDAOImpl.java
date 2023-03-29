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

public class EngineerDAOImpl implements EngineerDAO {

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
		}finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
