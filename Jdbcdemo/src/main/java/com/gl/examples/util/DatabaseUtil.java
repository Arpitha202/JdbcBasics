package com.gl.examples.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/ContactDb";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Root@123";

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	}// End of getConnection
}
