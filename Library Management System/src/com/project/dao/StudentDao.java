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
		
		public List<Book> getAllBooks(Connection con) {
			String query="SELECT * FROM books";
			
			List<Book> bookList=new ArrayList<>();
			
			try(PreparedStatement pst=con.prepareStatement(query)){
				
				/*
				 * automatic ah close aagarathuku ReseltSet ah nested try la podarom
				 */
				try(ResultSet rs=pst.executeQuery()){
					//ula yetho value iruntha maatum tha ula enter aagu
					
					/*
					 * instead of using if use while because ,if we use"if" it will return only one data
					 * but if we use "while" it will return  multiple data ->data irukara varaikum show aagum
					 */
					while(rs.next()) {
						Book book=new Book();
						/*
						 * in book table 
						 * CREATE TABLE books(
						 *  id SERIAL NOT NULL,
						 *  s_no INT NOT NULL, 
						 *  NAME VARCHAR(100) NOT NULL,
						 *  author_name VARCHAR(100) NOT NULL,
						 *   quantity INT,
						 * PRIMARY KEY(id) );
						 */
						// it all represents above table in db
						book.setAuthorName(rs.getString("author_name"));
						book.setBookName(rs.getString("NAME"));
						book.setId(rs.getInt("id"));
						book.setQuantity(rs.getInt("quantity"));
						book.setSerialNo(rs.getInt("s_no"));
						
						bookList.add(book);
					}
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return bookList;
		}
		
		
		
		//........................................................................................

		
		
		//........................................................................................

		
		//........................................................................................

}
