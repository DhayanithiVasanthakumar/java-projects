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
}
