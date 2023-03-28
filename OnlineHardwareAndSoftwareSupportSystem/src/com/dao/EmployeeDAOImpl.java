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

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public String RegisterEmployee(int deptid, String name, String username, String password) throws EmployeeException, ClassNotFoundException, SQLException {
        String res = "Oops! Your Details That You Entered Are Incorrect. Please Try Again!";
        Connection con = null;
        try {
            con = DBUtils.getConnectionToDatabase();
            PreparedStatement ps = con.prepareStatement("INSERT INTO employee (deptid,name,username,password) VALUES (?,?,?,?)");
            ps.setInt(1, deptid);
            ps.setString(2, name);
            ps.setString(3, username);
            ps.setString(4, password);

            try {
                int count = ps.executeUpdate();
                if(count>0) {
                    res = name+" Registration Successfull. The Username is [ "+username+" ] and Your Password is [ "+password+" ]";
                }else {
                    throw new EmployeeException("Registration Failed. Some Entries May be Incorrect.");
                }
            } catch (SQLException e) {
                String message = "An Error Occurred while Registering the Employee. Please Try Again With Valid Department ID.";
                throw new EmployeeException(message);
            }
        }finally {
            try {
                DBUtils.closeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
    
    @Override
	public Employee LoginEmployee(String username, String password) throws EmployeeException, ClassNotFoundException {
		Employee employee = new Employee();
		Connection con = null;
		try{
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE username = ? AND password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				employee.setEmpId(rs.getInt("empId"));
				employee.setDeptid(rs.getInt("deptId"));
				employee.setName(rs.getString("name"));
				employee.setUserName(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
			}else {
				throw new EmployeeException("Invalid Username or Password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employee;
	}
    
    @Override
	public int RaiseComplaintByTheEmployee(int empId, String complaintType) throws ComplaintException, ClassNotFoundException {
		int complaintId = 0;
		Connection con = null;
		try{
			con = DBUtils.getConnectionToDatabase();
 PreparedStatement ps = con.prepareStatement("INSERT INTO complaints (complaintId,empId,complaintType,status,dateRaised) values(?,?,?,?,?)");
			
			complaintId = (int) (Math.random()*10000);
			LocalDate dateRaised = LocalDate.now();
			ps.setInt(1, complaintId);
			ps.setInt(2, empId);
			ps.setString(3, complaintType);
			ps.setString(4, "Raised");
			ps.setDate(5, Date.valueOf(dateRaised));
			
			int num = ps.executeUpdate();
			
			if(num>0) {
				System.out.println("Complaint Raised Successfully\nYour Complaint No. is "+complaintId);
			}else {
				throw new ComplaintException("Oops! Complaint could Not be Raised. Please Try Again.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ComplaintException(e.getMessage());
		}finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return complaintId;
	}
    
    @Override
	public EngineerComplaintsDTO CheckComplaintStatusByEmployee(int complaintId) throws ComplaintException, ClassNotFoundException {
		
		EngineerComplaintsDTO complaindto = new EngineerComplaintsDTO();
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("SELECT c.complaintId, c.engId, e.name,c.complaintType, c.status, c.dateRaised FROM complaints c INNER JOIN engineer e ON c.engId = e.engId WHERE complaintId = ?");
			ps.setInt(1, complaintId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				complaindto.setComplaintId(rs.getInt("complaintId"));
				complaindto.setComplaintType(rs.getString("complaintType"));
				complaindto.setEngId(rs.getInt("engId"));
				complaindto.setName(rs.getString("name"));
				complaindto.setStatus(rs.getString("status"));
				complaindto.setDateRaised(rs.getDate("dateRaised"));
			}else {
				throw new ComplaintException("Complaint Not Assigned Yet. Please Check After Sometime.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ComplaintException(e.getMessage());
		}finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return complaindto;
	}
    
    
    @Override
	public List<Complaints> CheckComplaintHistoryByEmployee(int empId) throws ComplaintException, ClassNotFoundException {
		List<Complaints> list = new ArrayList<>();
		Connection con = null;
		try{
			con = DBUtils.getConnectionToDatabase();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM complaints WHERE empId = ?");
			
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
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
		}finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
    
}
