package com.project.dto;

public class BookingDetails {

	public int id;
	
	public int stuId;
	public int bookId;
	
	public String bookName;
	public String authorName;
	
	public int quantity;
	
	public int serialNo;

	
	/*
	 * getter and setter
	 */
	public int getBookingDetailsId() {
		return id;
	}

	public void setBookingDetailsId(int id) {
		this.id = id;
	}

	public int getBookingDetailsStuId() {
		return stuId;
	}

	public void setBookingDetailsStuId(int stuId) {
		this.stuId = stuId;
	}

	public int getBookingDetailsBookId() {
		return bookId;
	}

	public void setBookingDetailsBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookingDetailsBookName() {
		return bookName;
	}

	public void setBookingDetailsBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookingDetailsAuthorName() {
		return authorName;
	}

	public void setBookingDetailsAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getBookingDetailsQuantity() {
		return quantity;
	}

	public void setBookingDetailsQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getBookingDetailsSerialNo() {
		return serialNo;
	}

	public void setBookingDetailsSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	
	
}
