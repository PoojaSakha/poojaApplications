package com.sakha.global;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginUser {
	/*
	 * Get scanner from main method, Get email and password connect to db. do
	 * select statement with entered email and password execute query. get
	 * resultset if resultset has next --> if atleast one row exist, user exist.
	 * Login Success. else --> user doesn't exist.
	 */
	public void login(Scanner scanner) {
		String s2 = "", s1 = "";
	   	try {

			System.out.println("enter email");
			s1 = scanner.nextLine();
			if ((Validate.validateEmail(s1))) {
				System.out.println("enter password");
				s2 = scanner.nextLine();
				if (s2 != null && !s2.trim().equals("") && s2.length() >= 0 && s2.length() <= 6) {
					Connection con = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					try {
						con = ConnectioManager.getConnection();
						ps = con.prepareStatement("select * from Users where email=? and password=?");
						ps.setString(1, s1);
						ps.setString(2, s2);
						rs = ps.executeQuery();
						if (rs != null) {
							if (rs.next())
								System.out.println("Login Success");
							else
								System.out.println("User doesn't exist.");
						}

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						ConnectioManager.close(rs);
						ConnectioManager.close(ps);
						ConnectioManager.close(con);
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
