package com.project.bookValidator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {

	Scanner in= new Scanner(System.in);
	
	
	public static final String RED ="\u001B[31m";
	//RED use pana RESET use pananu ,panalana alla message um red color la display panu
	public static final String RESET ="\u001B[0m";
	
	
	/*
	 * ^ -> except 
	 * \\d ->digit
	 * { } -> range
	 * $ ->space
	 */
	
	//doesnot allow space ,range is 1 to 4
	private static Pattern ID_PATTERN=Pattern.compile("^\\d{1,4}$");
	//allow space ,range is a to z   and A to Z
	private static Pattern AuthorTittle_PATTERN=Pattern.compile("^[a-zA-Z ]+$");
	//doesnot allow space ,range is  4 digits
	private static Pattern PublishYear_PATTERN=Pattern.compile("^\\d{4}$");
	
	
	
	public String validateId() {
		
		String bookId;
		while(true) {
			System.out.println("Enter Book ID: ");
			bookId=in.nextLine();
			if(!ID_PATTERN.matcher(bookId).matches()) {
				System.out.println(RED+"SORRY ENTER VALID BOOK ID!!"+RESET);
			}else {
				break;
			}
		}
		return bookId;
	}
	
	public String validateAuthorTitle(String input) {
		
		String title;
		
		while(true) {
			if(input=="Title") {
				System.out.println("Enter Title: ");
			}else {
				System.out.println("Enter Author: ");
			}
			
			title=in.nextLine();
			if(!AuthorTittle_PATTERN.matcher(title).matches()) {
				System.out.println(RED+"SORRY ENTER VALID BOOK ID!!"+RESET);
			}else {
				break;
			}
		}
		return title;
	}
	
	public String validatePublishYear() {
		
		String year;
		
		while(true) {
			System.out.println("Enter publish year of book");
			year=in.nextLine();
			
			if(!PublishYear_PATTERN.matcher(year).matches()) {
				System.out.println(RED+"SORRY ENTER VALID YEAR!!"+RESET);
			}else {
				break;
			}
		}
		return year;
	}
	
	
}
