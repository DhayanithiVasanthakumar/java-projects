package com.project.dto;

import java.util.ArrayList;

public class Movie {

	private int id;
	private String name;
	private String language;
	private String genre;
	private int runningTime;
	private String starring;
	private String rate;
	private ArrayList<Show> show;
	
	public Movie() {
		show=new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public String getStarring() {
		return starring;
	}

	public void setStarring(String starring) {
		this.starring = starring;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public ArrayList<Show> getShow() {
		return show;
	}

	public void setShow(ArrayList<Show> show) {
		this.show = show;
	}
	
	
}
