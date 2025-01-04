package com.project.dto;
//6
public class Admin extends User{

	public Admin() {
		//it call User class.
		super();
	}

	@Override
	public void showList() {
		System.out.println("1.Add new Movie");
		System.out.println("2.Update movie");
		System.out.println("3.Show movie");
		System.out.println("4.Delete movie");
		System.out.println("5.Add Show Time");
		System.out.println("6.Update Show Time");
		System.out.println("7.Show Show Time");
		System.out.println("8.Delete Show Time");
		System.out.println("9.Add new Admin");
		System.out.println("10.Quit");
	}
	
}
