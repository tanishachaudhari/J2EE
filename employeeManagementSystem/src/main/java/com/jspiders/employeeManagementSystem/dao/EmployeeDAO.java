package com.jspiders.employeeManagementSystem.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.employeeManagementSystem.dto.Employee;

public class EmployeeDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	private static void openConnection() {

		entityManagerFactory = Persistence.createEntityManagerFactory("employee");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

	}

	private static void closeConnection() {

		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}

	}
   public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		openConnection();
		entityTransaction.begin();
		
		entityManager.persist(employee);
		entityTransaction.commit();
		closeConnection();
	}

   public void getAllEmployee() {
	// TODO Auto-generated method stub
	   openConnection();
	   entityTransaction.begin();
	   
	   Query query= entityManager.createQuery("select employee from Employee employee");
	   List<Employee> emp=query.getResultList();
	   for(Employee e:emp) {
		   System.out.println(e);
	   }
	   
	   entityTransaction.commit();
	   closeConnection();
	
   }

public void deleteEmployee(int id) {
	// TODO Auto-generated method stub
	openConnection();
	   entityTransaction.begin();
	   
	   Employee employee = entityManager.find(Employee.class, id);
		entityManager.remove(employee);
	   
	   entityTransaction.commit();
	   closeConnection();
	   
	
}



public void updateEmployee(int id, Scanner scanner) {
	// TODO Auto-generated method stub
	openConnection();
	entityTransaction.begin();

	Employee employee = entityManager.find(Employee.class, id);
	scanner.nextLine();
	System.out.println("Enter new employee name.");
	employee.setName(scanner.nextLine());
	System.out.println("Enter new employee email.");
	employee.setEmail(scanner.nextLine());
	System.out.println("Enter new employee salary.");
	employee.setSalary(scanner.nextDouble());
	entityManager.persist(employee);

	entityTransaction.commit();
	closeConnection();

	
}

public Employee employeeById(int id) {
	// TODO Auto-generated method stub
	openConnection();
	entityTransaction.begin();
	
	 Employee employee=entityManager.find(Employee.class,id );
	 System.out.println(employee);
	
	entityTransaction.commit();
	closeConnection();
	return employee;
}



public Employee employeeBySalary(double salary) {
	// TODO Auto-generated method stub
	openConnection();
	entityTransaction.begin();
	
	 Employee employee=entityManager.find(Employee.class,salary );
	 System.out.println(employee);
	
	entityTransaction.commit();
	closeConnection();
	
	return null;
}

public void employeeByName() {
	// TODO Auto-generated method stub
	openConnection();
	entityTransaction.begin();
	
	   Query query = entityManager.createQuery("select e from Employee e where name like '%ha'");
	   List<Employee> employees = query.getResultList();
	   for (Employee employee2 : employees) {
		System.out.println(employee2);
	   }
	
	entityTransaction.commit();
	closeConnection();
	
}

}
