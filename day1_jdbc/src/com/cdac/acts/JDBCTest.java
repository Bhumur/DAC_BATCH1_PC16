package com.cdac.acts;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.mysql.cj.jdbc.driver;

public class JDBCTest {

	public static void main(String[] args) {
		Connection dbConnection =null;
		Statement stselect = null;
		ResultSet result = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/user_batch1","root","cdac");
			System.out.println("connected");
			stselect =  dbConnection.createStatement();
			result = stselect.executeQuery("select * from users");
			
			while(result.next()) {
				String username = result.getString("username");
				String password = result.getString("password");
				String name = result.getString("name");
				String email = result.getString("email");
				String city = result.getString("city");
				System.out.println(username);
				System.out.println(password);
				System.out.println(name);
				System.out.println(email);
				System.out.println(city);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(dbConnection!=null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
	}

}
