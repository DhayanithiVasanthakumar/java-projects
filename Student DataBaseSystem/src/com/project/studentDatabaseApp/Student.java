package com.project.studentDatabaseApp;

import java.util.Scanner;

public class Student {
	/*
	 * variables
	 */
	private String firstname;
	private String lastname;
	private int gradeYear;
	private String studentID;
	private String courses="";
	private int tutionBalance=0;
	private static int costOfCourse=600;
	private static int id=1000;
	
	
	/*
	 * Constructor
	 */
	//prompt user to enter student's name and the year
	public Student() {
		Scanner in=new Scanner(System.in);
		//firstname
		System.out.println("Enter Student Firstname: ");
		this.firstname=in.nextLine();
		
		//lastname
		System.out.println("Enter Student Lastname: ");
		this.lastname=in.nextLine();
		
		//grade year
		System.out.println("\n1 - Fresher\n2 - sophomore\n3 - junior\n4 - senior\nEnter student grade level");
		this.gradeYear=in.nextInt();
		
		//student id
		setStudentId();
		
		
		//System.out.println(firstname+" "+lastname+" "+gradeYear+" "+studentID);
	}
	
	
	
	//generate an ID
	private void setStudentId() {
		//Grade level + id
		//whenever we create an obj for class, id(1000) will be increment by 1. because 'id' is in static.
		id++;
		this.studentID=gradeYear+""+id;
	}
	
	
	
	//enroll in courses
	public void enroll() {
		//get inside loop user press "Q" 
		do {
			System.out.print("Enter course to enroll(Q to quit): ");
			Scanner in=new Scanner(System.in);
			String enrollCourse=in.nextLine();
			if(!enrollCourse.equals("Q")) {
				courses=courses+"\n "+enrollCourse;
				tutionBalance=tutionBalance+costOfCourse;
			}
			else { 
				break; 
			}
		}while(1 != 0);
		
		//System.out.println("ENROLLED In :"+courses);
		//System.out.println("TUTION BALANCE: "+tutionBalance);
	}
	
	
	
	
	//view balance
	public void viewBalance() {
		System.out.println("Youe balance: "+tutionBalance );
	}
	
	
	
	//pay tution
	public void payTution() {
		viewBalance();
		System.out.print("Enter your payment: ₹");
		Scanner in=new Scanner(System.in);
		int payment=in.nextInt();
		tutionBalance=tutionBalance-payment;
		System.out.println("Thankyou for your payment of ₹: " +payment);
		viewBalance();
	}
	
	
	
	
	
	//show status
	//override toString()
	public String toString() {
		return "Name: "+firstname+" "+lastname+
				"\nGrade Level: "+gradeYear+
				"\nStudent ID: "+studentID+
				"\nCourses Enrolled: "+courses+
				"\nBalance: "+tutionBalance;
	}

}
