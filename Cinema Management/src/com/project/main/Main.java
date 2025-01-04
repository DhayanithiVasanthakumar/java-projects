package com.project.main;

import java.util.Scanner;

public class Main {

	private static Scanner in;
	public static void main(String[] args) {
		System.out.println("Welcome to Ticket Booking System");
		System.out.println("1.Login");
		System.out.println("2.Create New Account");
		
		in=new Scanner(System.in);
		
		int choice=in.nextInt();
		
		switch (choice) {
		case 1:
			login();
			break;
		case 2:
			createNewAccount();
			break;
		default:
			System.err.println("Invalid Input");
			break;
		}
		
		
	}
	//methods for login,create account
			private static void login() {
				System.out.println("Enter email:");
				String email=in.next();
				System.out.println("Enter Password:");
				String password=in.next();
			}
			
			private static void createNewAccount() {
				System.out.println("Enter your first name: ");
				String firstName=in.next();
				System.out.println("Enter your last name: ");
				String lastName=in.next();
				System.out.println("Enter your email: ");
				String email=in.next();
				System.out.println("Enter your phone number: ");
				String phNo=in.next();
				System.out.println("Enter your Password");
				String pass=in.next();
				System.out.println("Confirm Password");
				String confirmPass=in.next();
				
				while(!pass.equals(confirmPass)) {
					System.out.println("Password Doesn't match");
					System.out.println("Enter your Password");
					 pass=in.next();
					System.out.println("Confirm Password");
					 confirmPass=in.next();
				}
			}
}

