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
		 *  add student
		 * 
		 * CREATE TABLE students(
		id SERIAL NOT NULL,
		stu_name VARCHAR(100) NOT NULL,
		reg_no VARCHAR(100) NOT NULL,
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
		 * --> show all students
		 */
		public void showAllStudents(Connection showAllStudentCon) {
			
			StudentDao sd=new StudentDao();
			sd.getAllStudents(showAllStudentCon);
		}
	//--------------------------------------------------------------------------------------------------	

		
		

}
