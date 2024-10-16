package com.project.service;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.Scanner;

import com.project.dao.LoginDao;
import com.project.database.DatabaseConnection;
import com.project.menu.*;

public class LoginService {

	Scanner in=new Scanner (System.in);
	
	public void doLogin() {
		System.out.println("please provide username");
		String userName=in.nextLine();
		
		System.out.println("please provide password");
		String password=in.nextLine();
		
		try(Connection loginServicecon=DatabaseConnection.getConnection()) {
			
			LoginDao logindao=new LoginDao();
			String userType=logindao.doLogin(loginServicecon, userName, password);
			
			if(userName==null) {
				System.out.println("invalid user");
				return;
			}
			
			System.out.println("Login sucess. you logged in as a  "+userType+"  Please Select from below options");
			
			
			if(userName.equals("admin")) {
				/*
				 * display admin related menu
				 */
				AdminMenu am=new AdminMenu();
				am.displayAdminMenu(loginServicecon);
				
				
				
			}else {
				/*
				 * display student related menu
				 */
				UserMenu um=new UserMenu();
				um.displayUserMenu(loginServicecon);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
