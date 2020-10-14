package com.Hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String jdbcurl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimeZone=UTC";
			String username="hbstudent";
			String pass="hbstudent";
			
			System.out.print("connecting...");
			Connection con=DriverManager.getConnection(jdbcurl,username,pass);
			System.out.print("connected...");
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}

}
