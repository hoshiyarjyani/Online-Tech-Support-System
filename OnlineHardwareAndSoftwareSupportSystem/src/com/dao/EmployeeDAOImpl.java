package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.Employee;
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
    
}
