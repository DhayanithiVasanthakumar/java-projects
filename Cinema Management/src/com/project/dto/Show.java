package com.project.dto;

import java.time.LocalDateTime;

public class Show {

	private int id;
	private LocalDateTime showTime;
	private int capacity;
	private int bookedSeats;
	private String place;
	
	public Show() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getShowTime() {
		return showTime;
	}
	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getBookedSeats() {
		return bookedSeats;
	}
	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	
}
