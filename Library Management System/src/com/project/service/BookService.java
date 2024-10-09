package com.project.service;

import java.sql.Connection;
import java.util.Scanner;

import com.project.dao.BookDao;
import com.project.dto.Book;

public class BookService {

	Scanner in =new Scanner(System.in);
	
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
	
	
	/*
	 * for search by author name
	 */
	public void searchByAuthorName(Connection searchBookAuthorCon) {
		System.out.println("Enter author name of Book:");
		String authorName=in.nextLine();
		
		BookDao bd=new BookDao();
		Book bookDetails=bd.getBookByAuthorName(searchBookAuthorCon, authorName);
		
		if(bookDetails != null) {
			System.out.println("*****Book details*****");
			
			System.out.println("S.no : "+bookDetails.getSerialNo());
			System.out.println("Book Name : "+bookDetails.getBookName());
			System.out.println("Book Author Name : "+bookDetails.getAuthorName());
		}
		else {
			System.out.println("No Book for this "+ authorName+" is found!");
		}
		
	}
	
	
	

	/*
	 * case 1: -> search book option
	 */
	
	public void searchBook(Connection searchBookCon) {
		BookService bs=new BookService();
		
		
		
		System.out.println("1.Search with Book serial No: ");
		System.out.println("2.Search with Book author Name: ");
		
		System.out.println("Please enter your choice");
		int choice=in.nextInt();
		
		switch(choice) {
		case 1:
			//
			bs.searchBySerialNo(searchBookCon);
			break;
		case 2:
			//
			bs.searchByAuthorName(searchBookCon);
			break;
		default:
			System.out.println("Enter valid choice");
			break;
		}
	}
	
	
	
	
	
	
	
	
	
}
