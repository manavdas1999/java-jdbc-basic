package com.company.employee;

//importing
import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Boolean isSuccess = false;
		
		
		System.out.println("Welcome to Employee Management");
		
		while(true) {
			//menu for user
			System.out.println();
			System.out.println("1. Add Employee");
			System.out.println("2. Delete Employee");
			System.out.println("3. Read Employee");
			System.out.println("4. Exit");
			System.out.println("Your Input [1-4]: ");
			
			int ch = sc.nextInt();
			
			sc.nextLine();
			
			switch(ch){
				case 1: System.out.println("Enter employee name: ");
						String ename = sc.nextLine();
						
						System.out.println("Enter employee phone: ");
						String ephone = sc.nextLine();
						
						System.out.println("Enter employee dept: ");
						int edept = sc.nextInt();
						
						Employee employee = new Employee(ename, ephone, edept);
						
						System.out.println(employee.toString());
						
						isSuccess = EmployeeController.insertEmployeeIntoDb(employee);
						
						if(isSuccess) {
							System.out.println("Successful");
						}
						else {
							System.out.println("Unsuccessful");
						}

						break;
						
				case 2: 
						System.out.println("Enter employee id to delete: ");
						int eid = sc.nextInt();
						
						isSuccess = EmployeeController.deleteEmployeeFromDb(eid);
						
						if(isSuccess) {
							System.out.println("Successful");
						}
						else {
							System.out.println("Unsuccessful");
						}
						break;
						
				case 3: isSuccess = EmployeeController.showAllEmployeeFromDb();
				
						break;
						
				case 4: // exit
						break;
						
				default: // 
						break;
					
			}

		}
		
		
	}

}
