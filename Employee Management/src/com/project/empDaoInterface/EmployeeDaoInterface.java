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
	public void updateEmployee(int id,String name);
	
	//update employee salary
	//update employee age
	//both 2 are as same as updateEmployee
	
	//delete employee
	public void deleteEmployee(int id);
}
