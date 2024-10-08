package com.project.empDaoInterface;

import com.project.employeeApp.Employee;

public interface EmployeeDaoInterface {
	
	//create employee
	public void createEmployee(Employee emp);
	//show all employee
	public void showAllEmployee();
	//show employee based on id
	//user kitta iruntu input vangarom so parameter la variable set pananu
	public void showAllEmployeeBasedOnId(int id);
	
	
	
	//update employee name
	public void updateEmployeeName(int id,String name);
	//update employee salary
	public void updateEmployeeSalary(int id,double salary);
	//update employee age
	public void updateEmployeeAge(int id,int age);
	//update employee mobileno
	public void updateEmployeeMobileNo(int id,String mobileNo);
	//update employee email
	public void updateEmployeeEmail(int id,String email);
	
	
	
	
	//delete employee
	public void deleteEmployee(int id);
}
