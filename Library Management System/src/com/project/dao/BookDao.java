package com.project.dao;

import com.project.dto.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao {

	public Book getBookBySerialNo(Connection con,int serialNo) {
		String query="SELECT * FROM books WHERE s_no=?";
		
		try(PreparedStatement pst=con.prepareStatement(query)){
			
			pst.setInt(1, serialNo);
			
			/*
			 * automatic ah close aagarathuku ReseltSet ah nested try la podarom
			 */
			try(ResultSet rs=pst.executeQuery()){
				//ula yetho value iruntha maatum tha ula enter aagu
				if(rs.next()) {
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
					
					return book;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public Book getBookByAuthorName(Connection con,String authorName) {
		String query="SELECT * FROM books WHERE author_name=?";
		
		try(PreparedStatement pst=con.prepareStatement(query)){
			
			pst.setString(1, authorName);
			
			/*
			 * automatic ah close aagarathuku ReseltSet ah nested try la podarom
			 */
			try(ResultSet rs=pst.executeQuery()){
				//ula yetho value iruntha maatum tha ula enter aagu
				if(rs.next()) {
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
					
					return book;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}