package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Complaints;
import com.dto.Engineer;
import com.exception.ComplaintException;
import com.exception.EngineerException;

public class EngineerDAOImpl implements EngineerDAO{
	
	@Override
	public Engineer LogInEngineer(String username, String password) throws EngineerException, ClassNotFoundException {
		Engineer engineer = new Engineer();
		Connection con = null;
		try{
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM engineer WHERE username = ? AND password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				engineer.setEngId(rs.getInt("engId"));
				engineer.setName(rs.getString("name"));
				engineer.setUserName(rs.getString("username"));
				engineer.setPassword(rs.getString("password"));
				engineer.setType(rs.getString("type"));
				engineer.setLocation(rs.getString("location"));
			}else {
				throw new EngineerException("Wrong Credantials. Please Try Again.");
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
		return engineer;
	}
	
	@Override
	public List<Complaints> CheckAssignedComplaintsToEngineer(int engId) throws ComplaintException {
		List<Complaints> complaintsAssigned = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM complaints WHERE engId = ? AND status = 'Assigned'");
			
			ps.setInt(1, engId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
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

	
}
