package com.cdac.acts;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Assignment1 {

	public static void main(String[] args) {
		try(
				Scanner sc = new Scanner(System.in);
				Connection dbConnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/user_batch1","root","cdac");
				Statement stselect =  dbConnection.createStatement()
			) {
//			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Database Connected");
			int op ;
			do {
				System.out.println("Options :- ");
				System.out.println("1.   ShowAllusers in table");
				System.out.println("2.   Register User");
				System.out.println("3.   Show User on City bases");
				System.out.println("4.   Set New Password");
				System.out.println("5.   Show User detail by name");
				System.out.println("0.   EXIT");
				op = sc.nextInt();
				switch(op) {
				case 1: {
					System.out.println("ALL Users");
					allUsers(stselect);
					break;
				}
				case 2: {
					System.out.println("Register Users");
					registerUser(sc, stselect);
					break;
				}
				case 3:{
					System.out.println("Show users on city bases");
					System.out.print("Enter City : ");
					String cityName = sc.next();
					String sqlQuery = "select * from users where city = " + "'" + cityName + "'";
					ResultSet result = stselect.executeQuery(sqlQuery);
					while(result.next()) {
						String username = result.getString("username");
						String password = result.getString("password");
						String name = result.getString("name");
						String email = result.getString("email");
						String city = result.getString("city");
						System.out.println("Username : " +username);
						System.out.println("Password :" + password);
						System.out.println("Name : " + name);
						System.out.println("Email : " + email);
						System.out.println(city);
					}
					break;
				}
				case 4:{
					System.out.println("Set new Pass For User");
					System.out.print("Enter Username : ");
					String userName = sc.next();
					System.out.print("Enter New Password : ");
					String newPassword = sc.next();
					String sqlQuery = "update users set password = " + "'" + newPassword + "'" + "where username = " + "'" + userName + "'";
					if(stselect.executeUpdate(sqlQuery)==1) {
						System.out.println("added") ;
					}else {
						System.out.println("Failed");
					}
					break;	
				}
				case 5: {
					System.out.println("Show User detail by name");
					String Name = sc.next();
					String sqlQuery = "select * from users where name = " + "'" + Name + "'";
					ResultSet result = stselect.executeQuery(sqlQuery);
					while(result.next()) {
						String username = result.getString("username");
						String password = result.getString("password");
						String name = result.getString("name");
						String email = result.getString("email");
						String city = result.getString("city");
						System.out.println("Username : " +username);
						System.out.println("Password :" + password);
						System.out.println("Name : " + name);
						System.out.println("Email : " + email);
						System.out.println(city);
					}
					break;
				}
				case 0 : {
					break;
				}
				default : System.out.println("INVALID INPUT");
				}
			}while(op!=0);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void registerUser(Scanner sc, Statement stselect) throws SQLException {
		System.out.print("Enter Username : ");
		String username = sc.next();
		System.out.print("Enter Password : ");
		String password = sc.next();
		System.out.print("Enter Name : ");
		String name = sc.next();
		System.out.print("Enter Email : ");
		String email = sc.next();
		System.out.print("Enter City : ");
		String city = sc.next();
		String sqlInsert = "insert into users values" + "('" + username + "','" + password + "','" + name + "','" + email + "','" + city + "')" ;
		stselect.executeUpdate(sqlInsert);
		allUsers(stselect);
	}

	private static void allUsers(Statement stselect) throws SQLException {
		ResultSet result;
		result = stselect.executeQuery("select * from users");
		int x = 1;
		while(result.next()) {
			System.out.println(x + "th User :");
			x++;
			String username = result.getString("username");
			String password = result.getString("password");
			String name = result.getString("name");
			String email = result.getString("email");
			String city = result.getString("city");
			System.out.println("Username : " +username);
			System.out.println("Password :" + password);
			System.out.println("Name : " + name);
			System.out.println("Email : " + email);
			System.out.println(city);
		}
	}

}
