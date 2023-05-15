package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 
 * The DBUtils class provides utility methods to work with the database.
 * 
 * @author HoshiyarJyani
 */
public class DBUtils {
	/**
	 * Returns a connection object to the database.
	 *
	 * @return a connection object to the database.
	 * @throws ClassNotFoundException if the class is not found.
	 * @throws SQLException           if a database access error occurs.
	 */
	static Connection getConnectionToDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResourceBundle rs = ResourceBundle.getBundle("dbDetails");
		return DriverManager.getConnection(rs.getString("url"), rs.getString("username"), rs.getString("password"));
	}

	/**
	 * Closes the given connection to the database.
	 *
	 * @param con the connection object to be closed.
	 * @throws SQLException if a database access error occurs.
	 */
	static void closeConnection(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}

	/**
	 * Checks if a given result set is empty or not.
	 *
	 * @param rs the result set to be checked.
	 * @return true if the result set is empty, false otherwise.
	 * @throws SQLException if a database access error occurs.
	 */
	static boolean checkResultSet(ResultSet rs) throws SQLException {
		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
