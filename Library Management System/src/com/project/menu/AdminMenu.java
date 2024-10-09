package com.project.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.project.service.BookService;
import com.project.dao.*;

public class AdminMenu {
	Scanner in;
	
	BookService bookServiceObj=new BookService();
	
	public void displayAdminMenu(Connection adminCon) {
		in=new Scanner(System.in);
		int choice;
		do {
		System.out.println("********************************");
		System.out.println("1. Search a Book");
		System.out.println("2. Add new Book");
		System.out.println("3. Upgrade Quantity of Book");
		System.out.println("4. Show All Books");
		System.out.println("5. Register the Student");
		System.out.println("6. Show All Registered Students");
		System.out.println("7. Exit From Application");
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
			
			break;
		case 3:
			//Upgrade Quantity of Book
			
			break;
		case 4:
			//Show All Books
			
			break;
		case 5:
			//Register the Student
			
			break;
		case 6:
			//Show All Registered Students
			
			break;
		case 7:
			//Exit From Application
			System.out.println("Thankyou for using Library Mangement System");
			break;
		default:
			System.out.println("Please enter valid option!");
			break;
		}
		}while(choice != 7);
	}
	
	
	
	
	
}
