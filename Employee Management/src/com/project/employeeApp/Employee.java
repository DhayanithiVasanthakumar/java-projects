package com.project.employeeApp;

public class Employee {

	private int id;
	private String name;
	private double salary;
	private int age;
	private String mobileno;
	private String email;
	
	/*
	 * constructor
	 */
	public Employee(){
		
	}
	
	public Employee(int id,String name,double salary,int age,String mobileno,String email) {
		this.id=id;
		this.name=name;
		this.salary=salary;
		this.age=age;
		this.mobileno=mobileno;
		this.email=email;
		}
	
	
	
	
	/*
	 * getter and setter
	 */
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id=id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary=salary;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	
	
	public String getMoblieNo() {
		return mobileno;
	}
	public void setMobileNo(String mobileno) {
		this.mobileno=mobileno;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
	
	/*
	 * override toString()
	 */
	@Override
	public String toString() {
		return "ID: "+id+
				"\nNAME: "+name+
				"\nSALARY: "+salary+
				"\nAGE: "+age+
				"\nMobileNo: "+mobileno+
				"\nEmail: "+email;
	}
}
