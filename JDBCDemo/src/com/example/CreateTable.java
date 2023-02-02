package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		try {
			// Load oracle driver
			System.out.println("Loading db driver");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Create connection object
			System.out.println("Creating Connection to the db.");
			Connection conn=DriverManager.getConnection(  
						"jdbc:oracle:thin:@localhost:1521:orcl","scott","Wipro123");

			// Create statement object
			System.out.println("Creating statement object");
			Statement stmt = conn.createStatement();
			
			// Create query
			String query = "create table kumar"
					+ "("
					+ "kid number not null,"
					+ " name varchar2(50) unique,"
					+ " constraint kid_pk primary key (kid)"
					+ ")";
			
			// Execute query
			// execute() - used to execute DDL commands
			System.out.println("Executing create table query..");
			stmt.executeUpdate(query);
			
			System.out.println("Table created.");
			
			
			// close connection and statement
			stmt.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
