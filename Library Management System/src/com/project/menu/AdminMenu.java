package com.project.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.project.service.BookService;
import com.project.service.StudentService;
import com.project.dao.*;

public class AdminMenu {
	Scanner in;
	
	BookService bookServiceObj=new BookService();
	StudentService studentServiceObj=new StudentService();
	
	public void displayAdminMenu(Connection adminCon) {
		in=new Scanner(System.in);
		int choice;
		do {
		System.out.println("********************************");
		System.out.println("1. Search a Book");
		System.out.println("2. Add new Book");
		System.out.println("3. Delete Book");
		System.out.println("4. Update Book Details");
		System.out.println("5. Show All Books");
		System.out.println("6. Register the Student");
		System.out.println("7. Show All Registered Students");
		System.out.println("8. Exit From Application");
		System.out.println("********************************");
		
		System.out.println("Enter your Choice: ");
		
		choice=in.nextInt();
		
		
		switch(choice) {
		/*
		 * case 1,2,3,4 -> BookService class
		 */
		case 1:
			//search the book
			bookServiceObj.searchBook(adminCon);
			break;
		case 2:
			//Add new Book
			bookServiceObj.addBook(adminCon);
			break;
		case 3:
			//delete book
			bookServiceObj.deleteBook(adminCon);
			break;
			
		case 4:
			//Upgrade Quantity of Book
			bookServiceObj.updateBooks(adminCon);
			break;
		case 5:
			//Show All Books
			bookServiceObj.showAllBooks(adminCon);
			break;
		case 6:
			//Register the Student
			studentServiceObj.addStudent(adminCon);
			break;
		case 7:
			//Show All Registered Students
			
			break;
		case 8:
			//Exit From Application
			System.out.println("Thankyou for using Library Mangement System");
			break;
		default:
			System.out.println("Please enter valid option!");
			break;
		}
		}while(choice != 8);
	}

	
}
