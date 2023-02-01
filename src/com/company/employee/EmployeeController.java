package com.company.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeController {
	
	static Boolean insertEmployeeIntoDb(Employee employee) {
		
		Boolean statusOk = false;
		
		try {
			// creating connection
			Connection dbConnection = DBConnection.createConnection();
			
			String query = "insert into employee(ename, ephone, dept) values(?, ?, ?)";
			
			// prepared statement 
			PreparedStatement pstm = dbConnection.prepareStatement(query);
			
			// setting parameters
			pstm.setString(1, employee.getName());
			pstm.setString(2, employee.getPhone());
			pstm.setInt(3, employee.getDept());
			
			//execute statement
			pstm.executeUpdate();
			
			statusOk = true;
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return statusOk;
	
	}
	
	
	static Boolean deleteEmployeeFromDb(int eid) {
		
		Boolean statusOk = false;
		
		try {
			// creating connection
			Connection dbConnection = DBConnection.createConnection();
			
			String query = "delete from employee where eid = ?";
			
			// prepared statement 
			PreparedStatement pstm = dbConnection.prepareStatement(query);
			
			// setting parameters
			pstm.setInt(1, eid);

			
			//execute statement
			pstm.executeUpdate();
			
			statusOk = true;
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return statusOk;
	
	}
	
	static Boolean showAllEmployeeFromDb() {
		
		Boolean statusOk = false;
		
		try {
			// creating connection
			Connection dbConnection = DBConnection.createConnection();
			
			String query = "select * from employee";
			
			// Statement 
			Statement stm = dbConnection.createStatement();
					
			//execute statement
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
			
				int id = rs.getInt("eid");
				String name = rs.getString("ename");
				String phone = rs.getString("ephone");
				int dept = rs.getInt("dept");
				
				Employee e = new Employee(id, name, phone, dept);
				System.out.println(e.toString());
			}
			statusOk = true;
		}
				
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return statusOk;
	
		
	}
	
}
