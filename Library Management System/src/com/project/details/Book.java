package com.project.details;

public class Book {
	private String id;
	private String tittle;
	private String author;
	private String publishYear;
	private String  status;
	
	/*
	 * default constructor
	 */
	public Book() {
		
	}
	
	public Book(String id,String tittle,String author,String publishYear,String status) {
		this.id=id;
		this.tittle=tittle;
		this.author=author;
		this.publishYear=publishYear;
		this.status=status;
	}
	
	/*
	 * getter setter
	 */
	
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id=id;
	}
	
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle=tittle;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author=author;
	}
	
	public String getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(String publishYear) {
		this.publishYear=publishYear;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStaus(String status) {
		this.status=status;
	}
	
	
	
	public String toString() {
		return "ID: "+id+
				"TITTLE: "+tittle+
				"AUTHOR: "+author+
				"PUBLISH YEAR: "+publishYear+
				"STATUS: "+status;
	}
}
