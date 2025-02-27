package com.zumba.resource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	static String url = "jdbc:mysql://localhost:3306/project2";
	static String username = "root";
	static String password = "MySQL$h1t";
	static Connection con;
	
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password );
			
		} catch (Exception e) {
			System.out.println(e.toString());	
		}
	}
	
	public static Connection getDbConnection() {
		
		try {
			return con;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
}