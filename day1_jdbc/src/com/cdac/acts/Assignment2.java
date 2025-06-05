package com.cdac.acts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2 {
	
	public static void main(String[] args) {
	try(
			Scanner sc = new Scanner(System.in);
			Connection dbConnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/user_batch1","root","cdac");
			Statement stselect =  dbConnection.createStatement()
	){
		
			int op;
			
			do {
				System.out.println("Choice : ");
				System.out.println("1.  Add table");
				System.out.println("2.  Show Tables Coloums");
				System.out.println("Enter Your Choice : ");
				op = sc.nextInt();
				switch(op) {
				case 1:{
					System.out.println("NEW TABLE");
					System.out.print("Enter Table Name : ");
					String tableName = sc.next();
					ArrayList<String> colList = new ArrayList<>();
					String col ;
					do{
						System.out.print("Enter Coloumn or save for exit : ");
						col = sc.next();
						if(col.equals("save")) {
							break;
						}
						colList.add(col);
					}while(!col.equals("save"));
					int size = colList.size();
					// create table tablename(col1 datataype, ..... , 
					
					String sqlstring = "create table "  + tableName + "(" ;
//					for(int i=0;i<size;i++) {
//						if(i<size-1) {
//							coldatatype += "? ?,";
//						}else {
//							coldatatype += "? ?)";
//						}
//					}
//					System.out.println(coldatatype);
//					PreparedStatement psString = dbConnection.prepareStatement(coldatatype);
					String datatype;
					int x =1;
					for(int i=0;i<size;i++) {
						System.out.print("Enter datatype of " + colList.get(i) + " :");
						datatypeOption();
						int y = sc.nextInt();
						if(y==1) {
							datatype = "Varchar(45)";
						}else if(y==2) {
							datatype = "INT";
						}else {
							datatype = "FLOAT";
						}
						sqlstring +=  colList.get(i) + " "+ datatype + ",";
//						psString.setString(x, colList.get(i));
//						x++;
//						psString.setString(x, datatype);
//						x++;
					}
					System.out.print("Enter Coloum for Primary key : ");
					String key = sc.next();
					
					sqlstring += "Primary key(" + key + "));";	
					
					System.out.println("Quary : " + sqlstring);
					if(stselect.executeUpdate(sqlstring)==1) {
						System.out.println("Table Created");
					}else {
						System.out.println("Table Not Created");
					}
					break;
				}
				case 2:{
					System.out.println("Show table Coloums");
					String nameOfTable = sc.next();
					String sqlStament = "SHOW COLUMNS FROM " + nameOfTable;
					ResultSet result = stselect.executeQuery(sqlStament);
					while(result.next()) {
						System.out.println(result.getString("Field"));
					}
					break;
				}
				case 0:{
					
					
					break;
				}
				default: System.out.println("INVALID INPUT");
				}
				
			}while(op!=0);
		
		
		
		
		
	}catch(SQLException e) {
		
	}finally {
		
	}
}

	private static void datatypeOption() {
		System.out.println("DataType Choices : ");
		System.out.println("1.	Varchar(45)");
		System.out.println("2.	INT");
		System.out.println("3.	FLOAT");
		System.out.print("Enter your choice : ");
	}
}
