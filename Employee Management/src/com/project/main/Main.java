package com.project.main;

import java.util.Scanner;

import com.project.empDao.EmployeeDao;
import com.project.empDaoInterface.EmployeeDaoInterface;
import com.project.employeeApp.Employee;

public class Main {

	public static void main(String[] args) {
		
		String name;
		int id;
		double salary;
		int age;
		String mobileNo;
		String email;
		
		/*
		 * for access methods
		 */
		EmployeeDaoInterface dao=new EmployeeDao() ;
			
	
		
		System.out.println("Employee Management System");
		
		System.out.println("Enter your Choice: ");
		System.out.println(" ");
		Scanner in=new Scanner(System.in);
		
		do {
			System.out.println("1.Add Employee\n2.Show all Employees\n3.Show employee based on id\n4.update employee\n5.Delete employee\n6.Exit");
			
			int choice=in.nextInt();
			
			switch(choice) {
			case 1:
				Employee emp=new Employee();
				
				System.out.println("Enter ID: ");
				id=in.nextInt();
				
				System.out.println("Enter Name: ");
				 name=in.next();
				
				System.out.println("Enter salary: ");
				 salary=in.nextDouble();
				
				System.out.println("Enter Age: ");
				 age=in.nextInt();
				 
				 System.out.println("Enter mobile Number: ");
				 mobileNo=in.next();
				 
				 System.out.println("Enter email: ");
				 email=in.next();
				
				/*
				 * input ah vanganathu alla Employee class la obj muliyam ah antha method la irukara 
				 * parameter la set pananrom.
				 */
				emp.setID(id);
				emp.setName(name);
				emp.setSalary(salary);
				emp.setAge(age);
				emp.setMobileNo(mobileNo);
				emp.setEmail(email);
				
				dao.createEmployee(emp);
				break;
			case 2:
				dao.showAllEmployee();
				break;
			case 3:
				System.out.println("Enter employee id: ");
				 id=in.nextInt();
				dao.showAllEmployeeBasedOnId(id);
				break;
			case 4:
				System.out.println("Enter Employee ID to update: ");
				id=in.nextInt();
				
				System.out.println("Enter your choice: ");
				System.out.println("1.Name\n2.salary\n3.age\n4.mobileno\n5.email");
				
				int updateChoice=in.nextInt();
				
				switch(updateChoice) {
				case 1:
					System.out.println("Enter new Name: ");
					name=in.next();
					dao.updateEmployeeName(id, name);
					break;
				case 2:
					System.out.println("Enter new salary: ");
					salary=in.nextDouble();
					dao.updateEmployeeSalary(id, salary);
					break;
				case 3:
					System.out.println("Enter new age: ");
					age=in.nextInt();
					dao.updateEmployeeAge(id, age);
					break;
				case 4:
					System.out.println("Enter new mobileno: ");
					mobileNo=in.next();
					dao.updateEmployeeMobileNo(id, mobileNo);
					break;
				case 5:
					System.out.println("Enter new email: ");
					email=in.next();
					dao.updateEmployeeEmail(id, email);
					break;
				default:
					System.out.println("enter valid choice!!");
					break;
				}
				
				break;
				
			case 5:
				System.out.println("Enter employee id to delete: ");
				id=in.nextInt();
				dao.deleteEmployee(id);
				break;
			case 6:
				System.out.println("Thankyou for using application...");
				System.exit(0);
				break;
				
				
				
				/*
				 * write a method (File operation)
				 * to export the details stored in DB to some file 
				 * to import the details stored in DB to some file
				 */
			default:
				System.out.println("please enter valid choice!");
			}
			
			
		}while(true);
	}

}
