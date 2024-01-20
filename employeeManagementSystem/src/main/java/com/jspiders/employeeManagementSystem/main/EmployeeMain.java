//tauemp... table name Employee_info
package com.jspiders.employeeManagementSystem.main;

import java.util.Scanner;

import com.jspiders.employeeManagementSystem.dao.EmployeeDAO;
import com.jspiders.employeeManagementSystem.dto.Employee;

public class EmployeeMain {
	private static EmployeeDAO employeeDAO=new EmployeeDAO();
	public static void main(String[] args) {
		System.out.println("***** WELCOME TO EMPLOYEE-MANAGEMENT-SYSTEM *****");
		Scanner scanner=new Scanner(System.in);
		boolean flag=true;
		while (flag) {
			System.out.println("Enter 1 to add employee.\nEnter 2  to find all employees."
					+ "\nEnter 3 to update employee.\nEnter 4 to find employee by id."
					+ " \nEnter 5 to delete employee.\nEnter 6 to fetch the employee by name \nEnter 7 to exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: Employee employee = new Employee();
			       scanner.nextLine();
			       System.out.println("Enter employee name.");
			    employee.setName(scanner.nextLine());
			     System.out.println("Enter employee email.");
			    employee.setEmail(scanner.nextLine());
			    System.out.println("Enter employee salary.");
			    employee.setSalary(scanner.nextDouble());
			     employeeDAO.addEmployee(employee);
			     System.out.println("Employee added.");
		
			  break;
				
			case 2:
				employeeDAO.getAllEmployee();
				break;
				
				
			case 3:
				employeeDAO.getAllEmployee();
				System.out.println("Enter employee id.");
				employeeDAO.updateEmployee(scanner.nextInt(), scanner);
				System.out.println("Employee updated.");
				break;
				
			case 4: System.out.println("Enter employee id.");
			Employee employee2 = employeeDAO.employeeById(scanner.nextInt());
			if (employee2 != null) {
				System.out.println(employee2);
			} else {
				System.out.println("Employee not found.");
			}
				break;
				
			case 5:
				employeeDAO .getAllEmployee();
				System.out.println("Enter id");
				employeeDAO.deleteEmployee(scanner.nextInt());
				System.out.println("employee Deleted");
				break;
				
			case 6:
				employeeDAO.employeeByName();
				break;
			case 7:
				System.out.println("Thank you");
				flag=false;
				break;
				
				
		     default:
				System.out.println("Invalid choice");
			}
		}
	}

}
