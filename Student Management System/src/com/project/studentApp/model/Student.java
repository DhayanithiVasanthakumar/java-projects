package com.project.studentApp.model;

//1
public class Student {

	private String name;
	private int rollNumber;
	private String collegeName;
	private String city;
	private double percentage;

	/*
	 * default constructor
	 */
	public Student() {

	}

	/*
	 * parameterized constructor
	 */
	public Student(int rollNum, String name, String collegeName, String city, double percentage) {
		this.rollNumber = rollNum;
		this.name = name;
		this.collegeName = collegeName;
		this.city = city;
		this.percentage = percentage;
	}

	/*
	 * getter and setter
	 */

	public int getRollNum() {
		return rollNumber;
	}

	public void setRollNumber(int studentRollNumber) {
		this.rollNumber = studentRollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String studentName) {
		this.name = studentName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String studentCollegeName) {
		this.collegeName = studentCollegeName;
	}

	public String getCityName() {
		return city;
	}

	public void setCityName(String studentCityName) {
		this.city = studentCityName;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double studentPercentage) {
		this.percentage = studentPercentage;
	}

	/*
	 * override toString()
	 */

	public String toString() {
		return "Roll Number = " + rollNumber + "Name = " + name + "College Name = " + collegeName + "City = " + city
				+ "Percentage = " + percentage;
	}

}