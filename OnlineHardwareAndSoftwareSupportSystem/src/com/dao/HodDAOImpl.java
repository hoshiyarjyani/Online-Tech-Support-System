package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.HOD;
import com.exception.HODException;

public class HodDAOImpl implements HodDAO {

	@Override
	public HOD loginHodDAO(String username, String password) throws HODException, ClassNotFoundException {
		HOD hod = new HOD();

		try (Connection conn = DBUtils.getConnectionToDatabase()) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM hod WHERE username = ? AND password=?");
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
		}

		return hod;
	}

}
