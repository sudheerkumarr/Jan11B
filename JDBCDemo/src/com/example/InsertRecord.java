package com.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord {

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
			String query = "insert into kumar(kid, name) values(1005, 'Sam')";
			
			// Execute query
			System.out.println("Executing insert query");
			int result = stmt.executeUpdate(query);
			
			System.out.println("1 record inserted.");
			
			
			// close connection and statement
			stmt.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
