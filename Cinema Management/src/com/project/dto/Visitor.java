package com.project.dto;
//5
import java.util.ArrayList;

public class Visitor extends User {
	
	private ArrayList<Booking> bookings;

	public Visitor() {
		//it call User class.
		super();
	}
	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}
	
	@Override
	public void showList() {
		System.out.println("1.View movies");
		System.out.println("2.Book Tickets");
		System.out.println("3.Cancel Tickets");
		System.out.println("4.Quit");
		
	}
	
	
}
