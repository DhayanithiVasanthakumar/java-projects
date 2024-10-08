package com.project.main;

import java.util.Scanner;

import com.project.bookDao.BookDao;
import com.project.bookInterface.BookDaoInterface;


public class Main {
	public static void main(String[]args) {
		
		BookDaoInterface dao=new BookDao();
		
		Scanner in=new Scanner(System.in);
		
		
		do {
		System.out.println("Welcome to Library Management System");
		System.out.println("1.Add book\n2.Show All books\n3.Show Available books\n4.Borrow book\n5.return book\n6.exit");
		
		System.out.println("Enter your choice");
		int choice=in.nextInt();
		
		switch(choice) {
		case 1:
			dao.addBook();
			break;
		case 2: 
			dao.showAllBooks();
			break;
		case 3:
			dao.showAvailableBooks();
			break;
		case 4:
			dao.borrowBook();
			break;
		case 5:
			dao.returnBook();
			break;
		case 6:
			System.out.println("Thankyou for using application");
			System.exit(0);
		default:
			System.out.println("please enter valid choice");
			break;
		}
		
		
		
		
		}while(true);
		
	}
}
