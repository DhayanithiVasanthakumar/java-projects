package com.project.empDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.DBConnection.DataBaseConnection;
import com.project.empDaoInterface.EmployeeDaoInterface;
import com.project.employeeApp.Employee;

public class EmployeeDao implements EmployeeDaoInterface{

	Connection con;
	
	@Override
	public void createEmployee(Employee em) {
		con=DataBaseConnection.createDBConnection();
		String query="INSERT INTO emp_details VALUES(?,?,?,?,?,?);";
		
		try {
			PreparedStatement pst=con.prepareStatement(query);
			
			pst.setInt(1, em.getID());
			pst.setString(2, em.getName());
			pst.setDouble(3, em.getSalary());
			pst.setInt(4, em.getAge());
			pst.setString(5, em.getMoblieNo());
			pst.setString(6, em.getEmail());
			
			int count=pst.executeUpdate();
			if(count!=0) {
				System.out.println("Employee inserted sucessfully...");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void showAllEmployee() {
		con=DataBaseConnection.createDBConnection();
		String query="SELECT * FROM emp_details;";
		
		System.out.println("Employee Details:");
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		
		System.out.format("%s\t%s\t\t\t%s\t\t\t%s\t%s\t\t%s\n","ID","NAME","SALARY","AGE","MOBILENO","EMAIL");
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				/*
				 * %d -> for int
				 * %s -> for String
				 * %f -> for double
				 */
				System.out.format("%d\t%s\t\t\t%f\t\t%d\t%s\t\t%s\n",
						rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getString(6)
						);
				System.out.println("------------------------------------------------------------------------------------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void showAllEmployeeBasedOnId(int id) {
		con=DataBaseConnection.createDBConnection();
		String query="SELECT * FROM emp_details WHERE emp_id="+id;
		
		System.out.format("%s\t%s\t\t%s\t\t%s\n","ID","NAME","SALARY","AGE");
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				/*
				 * %d -> for int
				 * %s -> for String
				 * %f -> for double
				 */
				System.out.format("%d\t%s\t\t%f\t%d\n",
						rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getInt(4)
						
						
						);
				System.out.println("------------------------------------------------------------------------------------------------------------------------");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void updateEmployeeName(int id, String name) {
		
		con=DataBaseConnection.createDBConnection();
		
		String query="UPDATE emp_details SET emp_name=? WHERE emp_id=?";
		
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, name);
			pst.setInt(2, id);
			
			int count=pst.executeUpdate();
			
			if(count!=0) {
				System.out.println("update  Employee name sucessfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployeeSalary(int id, double salary) {
		con=DataBaseConnection.createDBConnection();
		
		String query="UPDATE emp_details SET emp_salary=? WHERE emp_id=?";
		
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setDouble(1, salary);
			pst.setInt(2, id);
			
			int count=pst.executeUpdate();
			
			if(count!=0) {
				System.out.println("update  Employee salary sucessfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void updateEmployeeAge(int id, int age) {
		con=DataBaseConnection.createDBConnection();
		
		String query="UPDATE emp_details SET emp_age=? WHERE emp_id=?";
		
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setDouble(1, age);
			pst.setInt(2, id);
			
			int count=pst.executeUpdate();
			
			if(count!=0) {
				System.out.println("update  Employee age sucessfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void updateEmployeeMobileNo(int id, String mobileNo) {
		con=DataBaseConnection.createDBConnection();
		
		String query="UPDATE emp_details SET emp_mobileno=? WHERE emp_id=?";
		
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, mobileNo);
			pst.setInt(2, id);
			
			int count=pst.executeUpdate();
			
			if(count!=0) {
				System.out.println("update  Employee mobileno sucessfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
	}

	@Override
	public void updateEmployeeEmail(int id, String email) {
		con=DataBaseConnection.createDBConnection();
		
		String query="UPDATE emp_details SET emp_email=? WHERE emp_id=?";
		
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, email);
			pst.setInt(2, id);
			
			int count=pst.executeUpdate();
			
			if(count!=0) {
				System.out.println("update  Employee email sucessfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
	
	
	@Override
	public void deleteEmployee(int id) {
		con=DataBaseConnection.createDBConnection();
		
		String query="DELETE FROM emp_details WHERE emp_id=?";
		
		try {
			PreparedStatement pst=con.prepareStatement(query);
			
			pst.setInt(1, id);
			
			int count=pst.executeUpdate();
			
			if(count!=0) {
				System.out.println("Employee deleted sucessfully!!!  "+id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	
}
