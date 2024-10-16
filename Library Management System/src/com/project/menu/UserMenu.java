package com.project.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.project.service.BookService;
import com.project.service.StudentService;

public class UserMenu {

	Scanner in;
	BookService bookServiceObj=new BookService();
	StudentService studentServiceObj=new StudentService();
	
	public void displayUserMenu(Connection userCon) {
		in=new Scanner(System.in);
		int choice;
		do {
		System.out.println("********************************");
		System.out.println("1. Search a Book");
		//take book
		System.out.println("2. Check out Book");
		//return book
		System.out.println("3. Chech in Book");
		System.out.println("4. Exit From Application");
		System.out.println("********************************");
		
		System.out.println("Enter your Choice: ");
		
		choice=in.nextInt();
		
		
		switch(choice) {
		/*
		 * case 1,2,3,4 -> BookService class
		 */
		case 1:
			//search the book from library
			bookServiceObj.searchBook(userCon);
			break;
		case 2:
			//get book from library
			bookServiceObj.checkOutBook(userCon);
			break;
		case 3:
			//delete book
			bookServiceObj.checkInBook(userCon);
			break;
			
		case 4:
			//Exit From Application
			System.out.println("Thankyou for using Library Mangement System");
			break;
		default:
			System.out.println("Please enter valid option!");
			break;
		}
		}while(choice != 4);
	}
}
