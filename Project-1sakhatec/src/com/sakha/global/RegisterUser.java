
package com.sakha.global;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class RegisterUser {
	// private static RegisterUser regi=null;
	/*
	 * public static RegisterUser getInstance() { if(regi==null) { reg=new
	 * RegisterUser(); return reg; } return null; } //this is a singleton class but in my project  not useful if someone else is using if they want singleton they can use it 
	 */
	/*
	 * Get scanner from main method, Get name, email, dob and password connect
	 * to db. do insert statement with the entered name, email, password and dob
	 * execute query.
	 */
	public void register(Scanner scanner) {
        
		String s1 = "";
		String s2 = "";
		String s3 = "";
		String s4 = "";
		try {
			System.out.println("Enter the Name");
			s1 = scanner.nextLine();
			if (Validate.validateName(s1)) {
				System.out.println("Enter the Email");
				s2 = scanner.nextLine();
				if (Validate.validateEmail(s2)) {
					System.out.println("Enter the password");
					s3 = scanner.nextLine();
					if (Validate.validatePassword(s3)) {
						System.out.println("Enter DOB(dd/MM/yyyy):");
						s4 = scanner.nextLine();
						if (Validate.validateDOB(s4)) {
							Connection con = null;
							PreparedStatement ps = null;
							try {
								con = ConnectioManager.getConnection();/*connect to database  getting connection from connection manager class*/							
								ps = con.prepareStatement("insert into Users (name,email,password,dob) values (?,?,?,?)"); 
								ps.setString(1, s1);
								ps.setString(2, s2);
								ps.setString(3, s3);
								ps.setDate(4,
										new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(s4).getTime()));
								ps.execute();
								System.out.println("Registration succesfull");

							} catch (Exception e) {
							} finally {
								ConnectioManager.close(ps);
								ConnectioManager.close(con);
							}
						}
					}
				}
			}
		} catch (Throwable e) {
			if (e instanceof Error) {
				System.out.println("system error");
			}
			if (e instanceof Exception) {
				System.out.println("exception" + e.getMessage());
			}
		}
	}
}