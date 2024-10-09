package com.project.service;

import java.sql.Connection;
import java.util.List;
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
	
	
	
	/*
	 * case 2 -> add book
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
	public void addBook(Connection addBookCon) {
		
		
		//id SERIAL NOT NULL,  --> it is auto increment ,so no need to get input
		
		System.out.println("Enter sno of book");
		int sno=in.nextInt();
		
		System.out.println("Enter Name of Book:");
		String bookName=in.next();
		
		System.out.println("Enter Name of Author:");
		String authorName=in.next();
		
		System.out.println("Enter quantity of book");
		int quantity=in.nextInt();
		
		
		BookDao bd=new BookDao();
		//bd obj Return Book class 
		Book book=bd.getBookBySerialNoOrAuthorName(addBookCon, sno, authorName);
		
		if(book != null) {
			System.out.println("Book already exists,So please try with diffrent Book");
			return;
		}
			Book bookInput=new Book();
			bookInput.setSerialNo(sno);
			bookInput.setBookName(bookName);
			bookInput.setAuthorName(authorName);
			bookInput.setQuantity(quantity);
			
			bd.saveBook(addBookCon, bookInput);
			
		
	}
	
	
	/*
	 * case 4 --> show all books
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
	
	
	
	/*
	 * case 3 -> update book
	 */
	
	
	public void updateBookQuantity(Connection addBookCon) {

		
		System.out.println("Enter sno of book");
		int sno=in.nextInt();
		
		
		BookDao bd=new BookDao();
		//bd obj Return Book class 
		Book book=bd.getBookBySerialNo(addBookCon, sno);
		
		if(book == null) {
			System.out.println("Book not available");
			return;
		}
		
		System.out.println("Enter number of books to be Added");
		int quantity=in.nextInt();
		
		
		
			Book bookInput=new Book();
			bookInput.setSerialNo(book.getSerialNo());
			bookInput.setQuantity(book.getQuantity()+quantity);
			
			bd.upgradeQuantity(addBookCon, bookInput);
			
		
	}
	
	
	
	
}
