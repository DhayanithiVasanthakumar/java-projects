package com.project.service;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.project.dao.BookDao;
import com.project.dao.StudentDao;
import com.project.dto.Book;
import com.project.dto.BookingDetails;

public class BookService {

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
	
//--------------------------------------------------------------------------------------------------	

	
//--------------------------------------------------------------------------------------------------	

	
	
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
	
//--------------------------------------------------------------------------------------------------	

	
//--------------------------------------------------------------------------------------------------	
	
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
//--------------------------------------------------------------------------------------------------	

	
	
//--------------------------------------------------------------------------------------------------	
	
	/*
	 * for updateBooks method
	 */

	//update book name
	public void updateBookName(Connection updateBookNameCon) {

		System.out.println("Enter sno of book");
		int sno = in.nextInt();

		BookDao bd = new BookDao();
		// bd obj Return Book class
		Book book = bd.getBookBySerialNo(updateBookNameCon, sno);

		if (book == null) {
			System.out.println("Book not available");
			return;
		}

		System.out.println("Enter new name of book");
		String newName = in.next();

		Book bookInput = new Book();
		bookInput.setSerialNo(book.getSerialNo());
		bookInput.setBookName(newName);

		bd.upgradeBookName(updateBookNameCon, bookInput);

	}

//update author name
	public void updateAuthorName(Connection updateAuthorNameCon) {

		System.out.println("Enter sno of book");
		int sno = in.nextInt();

		BookDao bd = new BookDao();
		// bd obj Return Book class
		Book book = bd.getBookBySerialNo(updateAuthorNameCon, sno);

		if (book == null) {
			System.out.println("Book not available");
			return;
		}

		System.out.println("Enter new Author nameof book");
		String newAuthorName = in.next();

		Book bookInput = new Book();
		bookInput.setSerialNo(book.getSerialNo());
		bookInput.setAuthorName(newAuthorName);

		bd.upgradeAuthorName(updateAuthorNameCon, bookInput);

	}

	// update quantity
	public void updateBookQuantity(Connection updateBookQuantityCon) {

		System.out.println("Enter sno of book");
		int sno = in.nextInt();

		BookDao bd = new BookDao();
		// bd obj Return Book class
		Book book = bd.getBookBySerialNo(updateBookQuantityCon, sno);

		if (book == null) {
			System.out.println("Book not available");
			return;
		}

		System.out.println("Enter number of books to be Added");
		int quantity = in.nextInt();

		Book bookInput = new Book();
		bookInput.setSerialNo(book.getSerialNo());
		bookInput.setQuantity(book.getQuantity() + quantity);

		bd.upgradeQuantity(updateBookQuantityCon, bookInput);

	}
	
	/*
	 *case 3 ->  update 
	 */
	public void updateBooks(Connection updateBooksCon) {
		
		BookService bs=new BookService();
			System.out.println("1.Book name: ");
			System.out.println("2.Book author Name: ");
			System.out.println("3.Book Quantity: ");
			
			System.out.println("Please enter your choice");
			int choice=in.nextInt();
			
			switch(choice) {
			case 1:
				//
				bs.updateBookName(updateBooksCon);
				break;
			case 2:
				//
				bs.updateAuthorName(updateBooksCon);
				break;
			case 3:
				bs.updateBookQuantity(updateBooksCon);
			default:
				System.out.println("Enter valid choice");
				break;
			
			}
	}
//--------------------------------------------------------------------------------------------------
	
	
	
//--------------------------------------------------------------------------------------------------

	/*
	 * delete book
	 */
	
	public void deleteBook(Connection deleteBookCon) {
		
		
		System.out.println("Enter sno of book");
		int sno = in.nextInt();

		BookDao bd = new BookDao();
		// bd obj Return Book class
		Book book = bd.getBookBySerialNo(deleteBookCon, sno);

		if (book == null) {
			System.out.println("Book not available");
			return;
		}
		
		System.out.println("Enter book ID to delete: ");
		int delBookId = in.nextInt();

		boolean delResult = bd.deleteBook(deleteBookCon, delBookId);

		if (delResult) {
			System.out.println("Book deleted sucessfully...");
		} else {
			System.out.println("Something went Wrong! Please try again");
		}
	}
	
	
//--------------------------------------------------------------------------------------------------
	/*
	 * check out book
	 */
	public void checkOutBook(Connection checkOutBookCon) {

		StudentDao sd = new StudentDao();
		BookDao bd = new BookDao();

		System.out.println("Enter register Nunber: ");
		String regNo = in.nextLine();

		boolean isExist = sd.getStudentByRegNo(checkOutBookCon, regNo);

		if (!isExist) {
			System.out.println("Student is not registered!,Get Registered first...");
			return;
		}

		showAllBooks(checkOutBookCon);

		System.out.println("Enter the Serial no of Book to check out");
		int sno = in.nextInt();

		// ithu Book ah return panu
		Book book = bd.getBookBySerialNo(checkOutBookCon, sno);

		if (book == null) {
			System.out.println("Book is not available");
			return;
		}

		// we need to update book quantity
		book.setQuantity(book.getQuantity() - 1);

		int id = sd.getStudentByRegNoForCheckOutBook(checkOutBookCon, regNo);

//public void saveBookingdetails(Connection saveBookingDetailsCon,int stuID,int bookID,int quantity)

		/*
		 * quantity is default ( 1 )-> because taking only one at a time.
		 */

		sd.saveBookingdetails(checkOutBookCon, id, book.getId(), 1);

		bd.upgradeQuantity(checkOutBookCon, book);

	}

//--------------------------------------------------------------------------------------------------

	public void checkInBook(Connection checkInBookCon) {
		System.out.println("Enter register number: ");
		String regNo=in.next();
		
		StudentDao sd=new StudentDao();
		boolean isExist=sd.getStudentByRegNo(checkInBookCon, regNo);
		
		if(isExist) {
			System.out.println("Student not registered! Get registered first...");
			return;
		}
		
		int id=sd.getStudentByRegNoForCheckOutBook(checkInBookCon, regNo);
		List<BookingDetails>bookingDetails=sd.getBookdetailsById(checkInBookCon, id);
		
		bookingDetails.stream().forEach(b -> System.out.println(b .serialNo+"\t\t\t"+b.bookName+"\t\t\t"+b.authorName));
		
		System.out.println("Enter Serial no of book to be Checked In: ");
		int sNo=in.nextInt();
		
		BookingDetails filterDetails=bookingDetails.stream().filter(b -> b.serialNo ==sNo).findAny().orElse(null);
		
		BookDao bd=new BookDao();
		Book book=bd.getBookBySerialNo(checkInBookCon, sNo);
		
		book.setQuantity(book.getQuantity() + 1);
		
		bd.upgradeQuantity(checkInBookCon, book);
		
		
		bd.deleteBook(checkInBookCon,filterDetails.getBookingDetailsBookId());
	}
	
}
