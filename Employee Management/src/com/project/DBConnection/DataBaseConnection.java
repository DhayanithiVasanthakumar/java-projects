package com.project.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	private static final String url = "jdbc:postgresql://localhost:5432/EmployeeManagement";
	private static final String user = "postgres";
	private static final String pass = "root";
	
	static Connection con;
	
	public static Connection createDBConnection() {
		
		
		try {
			//load driver
			Class.forName("org.postgresql.Driver");
			
			//connection
			con=DriverManager.getConnection(url,user,pass);
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		return con;
	}
}
