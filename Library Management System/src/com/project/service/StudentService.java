package com.project.service;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.project.dao.BookDao;
import com.project.dao.StudentDao;
import com.project.dto.Book;

public class StudentService {

	Scanner in =new Scanner(System.in);
	
	

	//--------------------------------------------------------------------------------------------------	

		/*
		 * for search by serial no
		 */
		public void searchBySerialNo(Connection searchBookSerialCon) {
			System.out.println("Enter serial no of Book:");
			int serialNo=in.nextInt();
			
			BookDao bd=new BookDao();
			Book bookDetails=bd.getBookBySerialNo(searchBookSerialCon, serialNo);
			
			if(bookDetails != null) {
				System.out.println("*****Book details*****");
				
				System.out.println("S.no : "+bookDetails.getSerialNo());
				System.out.println("Book Name : "+bookDetails.getBookName());
				System.out.println("Book Author Name : "+bookDetails.getAuthorName());
			}
			else {
				System.out.println("No Book for serial no "+ serialNo+" found!");
			}
			
		}
		
	
		
		
		

		
	//--------------------------------------------------------------------------------------------------	

		
		
		/*
		 *  add book
		 * 
		 * CREATE TABLE books(
			id SERIAL NOT NULL,  --> it is auto increment ,so no need to get input
			s_no INT NOT NULL,
			NAME VARCHAR(100) NOT NULL,
			author_name VARCHAR(100) NOT NULL,
			quantity INT,
			PRIMARY KEY(id)
			);
		 * 
		 */
		public void addStudent(Connection addStudentCon) {
			
			System.out.println("Enter Student Name :");
			String studentname=in.next();
			
			System.out.println("Enter Register number:");
			String regNo=in.next();
			
			
			
			StudentDao sd=new StudentDao();
			//bd obj Return Book class 
			boolean isStudentExists=sd.getStudentByRegNo(addStudentCon, regNo);
			
			if(isStudentExists) {
				System.out.println("Student already exists");
				return;
			}else {
				sd.saveStudent(addStudentCon, studentname, regNo);
			}
		}
		
	//--------------------------------------------------------------------------------------------------	

		
	//--------------------------------------------------------------------------------------------------	
		
		/*
		 * --> show all books
		 */
		public void showAllBooks(Connection showAllBookCon) {
			BookDao bd=new BookDao();
			// return type of getAllBooks is list.
			List<Book> showAllBook=bd.getAllBooks(showAllBookCon);
			
			//header
			System.out.println("+------------+--------------------+--------------------+------------+");
			System.out.println("|  Book s_no |        Name        |   Author name      |  Quantity  |");
			System.out.println("+------------+--------------------+--------------------+------------+");
			
			//ithu array la iruku so use foreach loop
			for(Book b:showAllBook) {
				
				//format -> give 12 empty space 
				System.out.printf("| %-10s | %-18s | %-18s | %-10s | \n",b.getSerialNo(),b.getBookName(),b.getAuthorName(),b.getQuantity());
				System.out.println("+------------+--------------------+--------------------+------------+");

				
			}
		}
	//--------------------------------------------------------------------------------------------------	

		
		

}
