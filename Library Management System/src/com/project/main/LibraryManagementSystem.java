package com.project.main;

import com.project.service.LoginService;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		System.out.println("***************** Welcome to Library ************");
		
		System.out.println("Log in for accessing menu");

		
		LoginService loginservice = new LoginService();
		loginservice.doLogin();
	}

}
