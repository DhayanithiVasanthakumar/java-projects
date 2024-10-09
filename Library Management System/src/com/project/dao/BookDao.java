package com.project.dao;

import com.project.dto.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
 * query class
 */
public class BookDao {

	
	//.................................................................................
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
	
	//................................................................................
	
	
	//........................................................................................
	
	/*
	 * combine 2 method for check add book in DB
	 */
	
	
	public Book getBookBySerialNoOrAuthorName(Connection con,int serialNo,String authorName) {
		String query="SELECT * FROM books WHERE s_no=? OR author_name=?";
		
		try(PreparedStatement pst=con.prepareStatement(query)){
			
			pst.setInt(1, serialNo);
			pst.setString(2, authorName);
			
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
	
	
	public void saveBook(Connection saveBookCon,Book book) {
		String query="INSERT INTO books(s_no,NAME,author_name,quantity) VALUES(?,?,?,?);";
		
		try(PreparedStatement pst=saveBookCon.prepareStatement(query)) {
			
			pst.setInt(1, book.getSerialNo());
			pst.setString(2, book.getBookName());
			pst.setString(3, book.getAuthorName());
			pst.setInt(4, book.getQuantity());
			
			int rows=pst.executeUpdate();
			
			if(rows>0) {
				System.out.println("Book added Sucessfully");
			}else {
				System.out.println("Failed to add book");
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

	/*
	 * upgrade the book quantity
	 */
	
	public void upgradeQuantity(Connection upgradeQuantityCon,Book updateBookObj) {
		String query="UPDATE books SET quantity=? WHERE s_no=?";
		
		try(PreparedStatement pst=upgradeQuantityCon.prepareStatement(query)){
			pst.setInt(1, updateBookObj.getQuantity());
			pst.setInt(2, updateBookObj.getSerialNo());
			
			int row=pst.executeUpdate();
			
			if(row>0) {
				System.out.println("Book quantity updated Sucessfully");
			}else {
				System.out.println("Failed to update book quantity");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * upgrade name of the book
	 */
	
	public void upgradeBookName(Connection upgradeBookCon,Book updateBookNameObj) {
		String query="UPDATE books SET NAME=? WHERE s_no=?";
		
		try(PreparedStatement pst=upgradeBookCon.prepareStatement(query)){
			pst.setString(1, updateBookNameObj.getBookName());
			pst.setInt(2, updateBookNameObj.getSerialNo());
			
			int row=pst.executeUpdate();
			
			if(row>0) {
				System.out.println("Book name updated Sucessfully");
			}else {
				System.out.println("Failed to update book name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * upgrade author name of book
	 */
	public void upgradeAuthorName(Connection upgradeAuthorCon,Book updateAuthorNameObj) {
		String query="UPDATE books SET author_name=? WHERE s_no=?";
		
		try(PreparedStatement pst=upgradeAuthorCon.prepareStatement(query)){
			pst.setString(1, updateAuthorNameObj.getAuthorName());
			pst.setInt(2, updateAuthorNameObj.getSerialNo());
			
			int row=pst.executeUpdate();
			
			if(row>0) {
				System.out.println("Author name updated Sucessfully");
			}else {
				System.out.println("Failed to update author name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//...............................................................................................
	
	
	
	//........................................................................................

	/*
	 * delete book
	 */
	
	public boolean deleteBook(Connection deleteBookCon,int sno) {
		boolean flag = false;
		String query="DELETE FROM books WHERE s_no= "+sno;
		
		try(PreparedStatement pst = deleteBookCon.prepareStatement(query);){
			
			
			pst.executeUpdate();
			

			flag = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	//........................................................................................

	
	//........................................................................................

}
