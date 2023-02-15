package com.gl.examples.util;

import static org.junit.Assert.assertFalse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DataBaseUtilTest {
	static DatabaseUtil util = new DatabaseUtil();

	@Test
	@DisplayName("Testing getConnectiontMethod")
	void getConnection() throws SQLException {
		Connection conn = util.getConnection();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContactDb", "root", "Root@123");
		assertFalse(con.equals(conn));

	}
}
