package com.project.emailApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Email {
	File file = new File(
			"C:\\Users\\dhaya\\eclipse-workspace\\Email Administrator\\src\\com\\project\\emailApp\\information.txt");
	public Scanner in = new Scanner(System.in);// Scanner class(global)for this class -> it access it in any where in
												// this class
	/*
	 * declare global variables-> as private for Security issues. it does not access
	 * directly.
	 */
	private String firstname;
	
	private String lastname;
	private String password;
	private String email;
	private String alteremail;
	private String department;
	private int mailcapacity = 500;
	private String companySuffix = "sat.com";

	/*
	 * constructor
	 */
	// To recive an firstname and last name.
	public Email(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		// System.out.println("Email Created Sucessfully :"+this.firstname+"
		// "+this.lastname);

		// call a method asking for the department return the department
		// this.department=setDepartment();
		// System.out.println("Department :"+" "+this.department);

		// call a method to generate a random password
		// this.password=randomPassword(defaultPasswordLength);
		// System.out.println("\nYour password is :"+this.password);

		// combine elements to generate a email.
		// email=firstname.toLowerCase()+"."+lastname.toLowerCase()+"@"+department+"."+companySuffix;
		// System.out.println("your email is :"+email);

		/*
		 * calling methods
		 */
		this.department = this.setDepartment();// department
		this.password = this.randomPassword(8);// password
		this.email = this.mailMethod();// email generation
	}

	/*
	 * methods
	 */

	// generate mail method.
	private String mailMethod() {
		return this.firstname.toLowerCase() + "." + this.lastname.toLowerCase() + "@" + this.department.toLowerCase()
				+ "." + this.companySuffix;
	}

	// ask for a department Method from user
	private String setDepartment() {
		System.out.print("New Worker :" + firstname
				+ "\n\nDepartment codes\n1: Front-end Developer\n2: Back-end Developer\n3: FullStack Developer\n0: none ");

		boolean flag = false;
		do {
			System.out.println("\nEnter Department code :");
			// Scanner class is defined in global.
			// to get department number form user
			String departmentChoice = in.nextLine();

			// use switch it is faster
			switch (departmentChoice) {
			case "1":
				return "Front-end Developer";
			case "2":
				return "Back-end Developer";
			case "3":
				return "FullStack Developer";
			case "0":
				return "None";
			default:
				System.err.println("Invalid Choice,Please choose it again:");
			}

			/*
			 * if else is slower compare to switch if(departmentChoice==1) { return "sales";
			 * } else if(departmentChoice==2) { return "Development"; } else
			 * if(departmentChoice==3) { return "Accounting"; } else return "None";
			 */
		}
		// !flag-> it make true,so again run-> do condition.
		while (!flag);
		return "";
	}

	// Generate a random password method.
	private String randomPassword(int length) {
		// Random is one of the class in java.it choose a give string randomly.
		Random r = new Random();
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "1234567890";
		String symbols = "!@#$%";

		String values = capitalLetters + smallLetters + numbers + symbols;
		String password = "";
		for (int i = 0; i < length; i++) {
			password = password + values.charAt(r.nextInt(values.length()));
		}
		return password;

		/*
		 * another way to create an random password. String
		 * passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$"; char[] password =new
		 * char[length]; for(int i=0;i<length;i++) { int
		 * rand=(int)(Math.random()*passwordSet.length());
		 * password[i]=passwordSet.charAt(rand); } return new String(password);
		 */
	}

	// change password method -> it is user activity so it is in public.
	// user will access it.
	public void setPassword() {
		boolean flag = false;
		do {
			System.out.println("Do you want to change password: (Y/N)");
			// index start with 0th position.
			// so charAt() type cast string it read at 0th index
			char passwordChoice = in.next().charAt(0);

			if (passwordChoice == 'Y' || passwordChoice == 'y') {
				// flag is true -> it stop do while loop and run below statements
				flag = true;
				System.out.println("Enter current password: ");
				String currentPassword = in.next();
				// current password equals old password
				if (currentPassword.equals(this.password)) {
					System.out.println("Enter new password: ");
					this.password = in.next();
					System.out.println("Password changed sucessfully.");
				} else {
					System.err.println("Incorrect password/");
				}
			} else if (passwordChoice == 'N' || passwordChoice == 'n') {
				flag = true;
				System.out.println("Password change option cancelled!");
			} else {
				System.err.println("Enter valid choice: ");
			}
		} while (!flag);
	}

	// set mailBoxCapacity method -> it is user activity so it is in public.
	// user will access it.
	public void setMailBoxCapacity() {
		System.out.println("Current mail box capacity :" + this.mailcapacity + "mb");
		System.out.println("Enter new mail boc capacity :");
		this.mailcapacity = in.nextInt();
		System.out.println("Mail box capacity sucessfully updated");
	}

	// set alternate mail method ->it is user activity so it is in public.
	public void setAlternateEmail() {
		System.out.println("Enter alternate mail: ");
		this.alteremail = in.next();
		System.out.println("Altername email is updated");
	}

	// Show all information in single method.
	public void showInfo() {
		System.out.println("Name: " + this.firstname + "" + this.lastname);
		System.out.println("Department: " + this.department);
		System.out.println("Email: " + this.email);
		System.out.println("Password: " + this.password);
		System.out.println("Mailbox Capacity: " + this.mailcapacity + "mb");
		System.out.println("Alternate Email: " + this.alteremail);
	}

	// store in file
	public void storeFile() {
		// write file
		try {
			// bufferWriter use pana whenever run program it erase all data and create new
			// file.
			// so ithu fix pana append pananum ithu pana data um change aagathu.
			// FileWriter fwriter=new FileWriter(file,true);

			FileWriter fwriter = new FileWriter(file,true);
			BufferedWriter bwriter = new BufferedWriter(fwriter);
			bwriter.write("\nFirstname: " + this.firstname);
			bwriter.write("\nLastname: " + this.lastname);
			bwriter.write("\nEmail: " + this.email);
			bwriter.write("\nPassword: " + this.password);
			bwriter.write("\nCapacity: " + this.mailcapacity);
			bwriter.write("\nAlternate email: " + this.alteremail);
			bwriter.write("\n********");

			bwriter.flush();
			bwriter.close();
			System.out.println("Data Stored...");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Reading file method
	public void readFile() {
		// read file
		try {
			FileReader freader = new FileReader(file);
			BufferedReader breader = new BufferedReader(freader);
			// .readLine() return type is String
			String line = breader.readLine();

			while (line != null) {
				line = breader.readLine();
				System.out.println(line);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}