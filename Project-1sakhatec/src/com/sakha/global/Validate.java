
package com.sakha.global;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	public static boolean validateName(String name) {
		boolean flag = false;
		if (name == null || name.trim().equals(
				"")) /* checking whether name is null and is not equal to "" */
			flag = false;
		else {

			if (name.split(" ").length > 1) /* it checks spaces in the String */
				flag = false;
			if (name.length() > 100)
				flag = false;
			else/* name length is <100 */
			{
				if (!Character.isLetter(name.charAt(0)))
					flag = false;
				else {
					for (int i = 0; i < name.length(); i++) {
						char c = name.charAt(i);
						if (!(Character.isDigit(c) || Character.isLetter(c)))
							flag = false;
					}
					return true;
				}
			}
		}
		if (!flag) {
			throw new IllegalArgumentException("Something went name please check out");
		} else {
			return true;
		}
	}

	public static boolean validateDOB(String date) {
		char[] ca = date.toCharArray();
		String day = "", month = "", year = "";
		day = day + ca[0] + ca[1];// storing day to day string//
		month = month + ca[3] + ca[4];// storing month to month string//
		year = year + ca[6] + ca[7] + ca[8] + ca[9];// storing year to month
													// string//
		if (Integer.parseInt(day) > 0 && Integer.parseInt(day) <= 31) // if day
																		// is
																		// between
																		// 0-31//
		{
			return true;
		}
		if (Integer.parseInt(month) > 0 && Integer.parseInt(day) <= 12) // if
																		// month
																		// is
																		// between
																		// 0-12//
		{
			return true;
		}
		if (Integer.parseInt(year) > 1900 && Integer.parseInt(year) <= 2017) // if
																				// year
																				// is
																				// between
																				// 1900
																				// and
																				// 2017//
		{
			return true;
		}
		throw new IllegalArgumentException("Something went wrong check ot DOB");
	}

	public static boolean validateEmail(String email) {
		/*
		 * Pattern p=Pattern.compile("[a-z]*[0-9]*@[a-z]*.[a-z]"); Matcher
		 * m=p.matcher(email); boolean b=m.matches(); if(b==true) { return true;
		 * }
		 */
		if (email.matches("([a-z]|[0-9])*@[a-z]*.[a-z]*")) 
		{
			return true;
		}
		throw new IllegalArgumentException("Something went wrong please check the email");// throw
																							// an
																							// exception
																							// if
																							// any
																							// validation
																							// fails//
	}

	public static boolean validatePassword(String s3) {
		if (s3 != null && s3.trim().equals("") && s3.length() > 0 || s3.length() <= 6)
			return true;
		throw new IllegalArgumentException("Password length:6");
	}

}