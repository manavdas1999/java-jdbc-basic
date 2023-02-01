package com.company.employee;

import java.sql.DriverManager;
import java.sql.Connection;

public class DBConnection {
	
	static Connection con;
	
	static Connection createConnection(){
		
		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create connection
			String url = "jdbc:mysql://localhost:3306/employee_management";
			String user = "root";
			String password = "1234";
						
			con = DriverManager.getConnection(url, user, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	
	}
}
