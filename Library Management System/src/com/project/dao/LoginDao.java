package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	public String doLogin(Connection loginCon,String userName,String password) {
		/*
		 * db la login table la set pana username password crt ah nu check panu
		 */
		String query="SELECT * FROM login WHERE user_name=? AND password=?";
		
		try {
			PreparedStatement pst=loginCon.prepareStatement(query);
			
			pst.setString(1, userName);
			pst.setString(2, password);
			
			try(ResultSet rs=pst.executeQuery()){
				if(rs.next()) {
					return rs.getString("user_type");
				}
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
