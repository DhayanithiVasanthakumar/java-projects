package com.project.bookDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.bookInterface.BookDaoInterface;
import com.project.bookValidator.Validator;
import com.project.details.Book;

public class BookDao implements BookDaoInterface{

	
	public static final String RED ="\u001B[31m";
	//RED use pana RESET use pananu ,panalana alla message um red color la display panu
	public static final String RESET ="\u001B[0m";
	public static final String BLUE ="\u001B[34m";
	public static final String GREEN ="\u001B[32m";
	public static final String CYAN ="\u001B[36m";
	public static final String BLACK ="\u001B[30m";
	
	Scanner in=new Scanner(System.in);
	
	Validator validateObj=new Validator();
	
	Book bookObj=new Book();
	
	//list of the Book class
	List<Book> books=new ArrayList<>();
	
	@Override
	public void addBook() {
		String bookID=validateObj.validateId();
		String title=validateObj.validateAuthorTitle("Title");
		String author=validateObj.validateAuthorTitle("Author");
		String year =validateObj.validatePublishYear();
		
		Book book=new Book(bookID,title,author,year,"Available");
		
		books.add(book);
		
		System.out.println(GREEN+"Book Added Successfully"+RESET);
	}

	@Override
	public void showAllBooks() {
		
		boolean flag = false;

		System.out.println("\n-----------------------------------------------------------------------------------");
		System.out.format(CYAN+"%s%15s%15s%15s%15s", "ID", "TITLE", "AUTHOR", "PUBLISH YEAR", "STATUS"+RESET);
		System.out.println("\n-----------------------------------------------------------------------------------");

		for (Book b : books) {
			System.out.format("%s%15s%15s%15s%15s", b.getID(), b.getTittle(), b.getAuthor(),
					b.getPublishYear(), b.getStatus());
			System.out.println();

			/*
			 * library la yetho book iruntha true library la yentha book um ilana false
			 */
			flag = true;
		}
		System.out.println("\n-----------------------------------------------------------------------------------");

		if (flag == false) {
			System.out.println(RED + "There is no book in library" + RESET);
		}
	}

	@Override
	public void showAvailableBooks() {
		boolean flag = false;

		System.out.println("\n-----------------------------------------------------------------------------------");
		System.out.format(CYAN+"%s%15s%15s%15s%15s", "ID", "TITLE", "AUTHOR", "PUBLISH YEAR", "STATUS"+RESET);
		System.out.println("\n-----------------------------------------------------------------------------------");

		
		if(books.size()>0) {
			for (Book b : books) {
				if(b.getStatus()=="Available") {
					System.out.format("%s%15s%15s%15s%15s", b.getID(), b.getTittle(), b.getAuthor(),
							b.getPublishYear(), b.getStatus());
					System.out.println();

					/*
					 * library la yetho book iruntha true library la yentha book um ilana false
					 */
					flag = true;
				}else {
					System.out.println(RED + "No book available in library" + RESET);
				}
				System.out.println("\n-----------------------------------------------------------------------------------");

			}
			if (flag == false) {
				System.out.println(RED + "There is no book with status availabe" + RESET);
			}
		}	
	}

	@Override
	public void borrowBook() {
		String bookId=validateObj.validateId();
		boolean flag=false;
		
		for(Book b:books) {
			if(b.getID().equals(bookId)&&b.getStatus().equals("Available")) {
				flag=true;
				System.out.println(GREEN+"Borrowed Sucessfully"+RESET);
				b.setStaus("Not Available");
				
				System.out.println("Borrowed details"+b);
			}
		}
		if(flag==false) {
			System.out.println(RED+"this book is not available to borrow"+RESET);
		}
		
	}

	@Override
	public void returnBook() {
		String bookId=validateObj.validateId();
		boolean flag=false;
		
		for(Book b:books) {
			if(b.getID().equals(bookId)&&b.getStatus().equals("Not Available")) {
				flag=true;
				System.out.println(GREEN+"Book Returned Sucessfully"+RESET);
				b.setStaus("Available");
				
				System.out.println("Returned book details"+b);
			}
		}
		if(flag==false) {
			System.out.println(RED+"We cannot return this book "+RESET);
		}		
	}
	
}
