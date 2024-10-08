package com.project.atmApp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	private static final String url = "jdbc:postgresql://localhost:5432/ATM Application";
	private static final String user = "postgres";
	private static final String pass = "root";

	static Connection con;

	public static Connection createConnection() {

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return con;

	}
}
