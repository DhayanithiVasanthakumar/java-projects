package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.dto.Book;

public class StudentDao {

	//.................................................................................
		public boolean getStudentByRegNo(Connection con,String regNo) {
			String query="SELECT * FROM students WHERE reg_no=?";
			
			try(PreparedStatement pst=con.prepareStatement(query)){
				
				pst.setString(1, regNo);
				
				/*
				 * automatic ah close aagarathuku ReseltSet ah nested try la podarom
				 */
				try(ResultSet rs=pst.executeQuery()){
					return rs.next();
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		
		}
		
		
		//................................................................................
		
		
		
		
		public void saveStudent(Connection saveStudentCon,String studentName,String regNo) {
			String query="INSERT INTO students(stu_name,reg_no) VALUES(?,?);";
			
			try(PreparedStatement pst=saveStudentCon.prepareStatement(query)) {
				
				pst.setString(1,studentName);
				pst.setString(2,regNo);
			
				
				int rows=pst.executeUpdate();
				
				if(rows>0) {
					System.out.println("Student added Sucessfully");
				}else {
					System.out.println("Failed to add Student");
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		//........................................................................................

		
		//........................................................................................

		
		/*
		 * show all books
		 */
		
		public void getAllStudents(Connection con) {
			String query = "SELECT * FROM students";

			// header
			System.out.println("+------------+--------------------+--------------------+");
			System.out.println("|    id      |        Name        |   regesiterNumber  |");
			System.out.println("+------------+--------------------+--------------------+");

			try (PreparedStatement pst = con.prepareStatement(query)) {

				/*
				 * automatic ah close aagarathuku ReseltSet ah nested try la podarom
				 */
				try (ResultSet rs = pst.executeQuery()) {
					// ula yetho value iruntha maatum tha ula enter aagu

					/*
					 * instead of using if use while because ,if we use"if" it will return only one
					 * data but if we use "while" it will return multiple data ->data irukara
					 * varaikum show aagum
					 */

					// ithu array la iruku so use foreach loop
					while (rs.next()) {

						// format -> give 12 empty space
						System.out.printf("| %-10s | %-18s | %-18s | \n", rs.getInt(1), rs.getString(2),
								rs.getString(3));
						System.out.println("+------------+--------------------+--------------------+");

					}

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		
		//........................................................................................

		
		
		//........................................................................................

		
		//........................................................................................

}
