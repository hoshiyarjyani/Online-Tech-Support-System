package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Complaints;
import com.dto.Engineer;
import com.dto.HOD;
import com.exception.ComplaintException;
import com.exception.DepartmentException;
import com.exception.EngineerException;
import com.exception.HODException;
import com.exception.NoRecordFoundException;

public class HodDAOImpl implements HodDAO {

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
				res = "Engineer Registered Sucessfully";
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

	
	@Override
	public List<Complaints> CheckComplaintsByHodDAO() throws ComplaintException, ClassNotFoundException, NoRecordFoundException {
		List<Complaints> list = new ArrayList<>();
		Connection con = null;
		try{
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM complaints WHERE status = 'Raised'");
			
			ResultSet rs = ps.executeQuery();
			if (DBUtils.checkResultSet(rs)) {
				throw new NoRecordFoundException("No Complaint found");
			}
			while(rs.next()) {
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
		}finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	@Override
	public String AssignComplaintToEngineerByHOD(int complaintId, int engineerId) throws EngineerException, ClassNotFoundException {
		String result = "Complaint-Id Not Found in Database. Please Enter a Valid Complaint-Id.";
		Connection con = null;
		try{
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("UPDATE complaints SET engId = ?, status = 'Assigned' where complaintId = ?");
			
			ps.setInt(1, engineerId);
			ps.setInt(2, complaintId);
			
			int count = ps.executeUpdate();
			if(count>0) {
				result = "Complaint with ID " + complaintId +" Assigned to Engineer who's ID is " + engineerId;
			}else {
				throw new EngineerException("Engineer or Complaint Not Found In Records.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
		}
		
		return result;
	}
	
	
	@Override
	public String RegisterDepartment(String dname, String location)throws ClassNotFoundException, DepartmentException {
		String result = "";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("INSERT INTO department (dname,location) values(?,?)");

			ps.setString(1, dname);
			ps.setString(2, location);

			int x = ps.executeUpdate();
			if (x > 0) {
				result = "Department Registered Sucessfully. The Name Of Department is "+dname;
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
}
