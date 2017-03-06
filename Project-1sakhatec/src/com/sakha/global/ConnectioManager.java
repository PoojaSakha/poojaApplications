package com.sakha.global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectioManager {
	/*
	 * load driver class get connection from drivermanager return connection
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");/*loading the driver*/
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root123");/*registering driver to driver manager and connecting to the database*/
		return con;
	}

	/*
	 * null check, close prepared statement
	 */
	public static void close(PreparedStatement ps) 
	{
		if (ps != null)
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	// null check, close connection
	public static void close(Connection con) {
		// TODO Auto-generated method stub
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	// null check, close connection
	public static void close(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}