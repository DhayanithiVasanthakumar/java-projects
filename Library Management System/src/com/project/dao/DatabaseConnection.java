package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String url = "jdbc:postgresql://localhost:5432/Library Management";
	private static final String user = "postgres";
	private static final String pass = "root";

	public static Connection con;

	private static Connection createConnetion() {

		try {
			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection(url, user, pass);

			System.out.println("Database connection created sucessfully.");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return con;
	}
	
	public static Connection getConnection() {
		
		if(con==null) {
			return createConnetion();
		}
		
		return con;
	}

	
}
