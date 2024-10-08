package com.project.studentDatabaseApp;

import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		
		/*it take to create an obj for each students -> it is inefficient.
		Student stu1=new Student();
		stu1.enroll();
		stu1.payTution();
		//this method is return type so we put in to sysout
		System.out.println(stu1.toString());
		*/
		
		
		
		
		//how many new students you want to be add
		System.out.println("Enter number of new students to enroll: ");
		Scanner in=new Scanner(System.in);
		int numOfStudents=in.nextInt();
		Student[] students=new Student[numOfStudents];
		
		
		//create a n number of students
		for(int n=0;n<numOfStudents;n++) {
			students[n]=new Student();
			students[n].enroll();
			students[n].payTution();
		}
		
		for(int n=0;n<numOfStudents;n++) {
			//this method is return type so we put in to sysout
			System.out.println(students[n].toString());
		}
	}

}
