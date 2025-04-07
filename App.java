package com.kodnest.EmployeeManagement;


import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {

	static Scanner sc = new Scanner(System.in);
	static SessionFactory factory;
    public static void main(String[] args) {

    	factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	
    	Scanner sc = new Scanner(System.in);
    	
    	while(true) {
    	System.out.println("Press-1 ---> CREATE");
    	System.out.println("Press-2 ---> READ");
    	System.out.println("Press-3 ---> UPDATE");
    	System.out.println("Press-4 --->  DELETE");
    	System.out.println("Other Number ---> STOP");
    	
    	
    	int choice = sc.nextInt();
    	
    	switch(choice) {
    	case 1->createUser();
    		
    	case 2->ReadUser();
    		
    	case 3->UpdateUser();
    		
    	case 4->DeleteUser();
    		
    	default->
    	System.out.println("Thankyou for using emploee Management System");
    	}
    }
    }
   public static void createUser() {
	   System.out.println("Enter Employee name, salary, password and Age");
	   String name= sc.next();
	   int salary = sc.nextInt();
	   int password = sc.nextInt();
	   int age = sc.nextInt();
	   
	   Employee  emp = new  Employee(name,salary,password,age);
	   
	  Session session = factory.openSession();
	  
	Transaction trans = session.beginTransaction();
	  
	  session.persist(emp);
	  
	 trans.commit();
	 
	 session.close();
	
	  
	  }
   
   public static  void ReadUser() {
	   System.out.println("Enter Employee ID");
	   int id = sc.nextInt();
	   
	  Session session = factory.openSession();
	  
	Transaction trans = session.beginTransaction();
	  
	   Employee e = (Employee)session.get("Employee.class",id);
	  
	   System.out.println("ID|Name|Salary|Password|Age");
	   System.out.println(e);
	 trans.commit();
	 
	 session.close();
	
	   
   }
   
   public static void UpdateUser() {
	   System.out.println("Enter Employee ID to Update");
	   int id = sc.nextInt();
	   
	  Session session = factory.openSession();
	  
	Transaction trans = session.beginTransaction();
	 
	   Employee e = (Employee)session.get("Employee.class",id);
	  if(e!=null){ 
	 System.out.println("Press-A to Update Name");
	 System.out.println("Press-B to Update Salary");
	 System.out.println("Press-C to Update Password");
	 System.out.println("Press-D to Update Age");
	 
	 char choice = sc.next().charAt(0);
	 System.out.println("Enter new Data");
	 switch(choice) {
	 case 'A'-> e.setName(sc.next());
	 
	 case 'B'-> e.setSalary(sc.nextInt());
	 
	 case 'C'-> e.setPassword(sc.nextInt());
	 
	 case 'D' -> e.setAge(sc.nextInt());
	 
	 default ->
		 e.setSalary(sc.nextInt());
	 
	 }
	   session.merge(e);
	   trans.commit();
		 
		 session.close();
		
	  }else {
		  System.out.println("Invalid Input");
	  }
   }
   
   public static  void DeleteUser() {
	   
	   System.out.println("Enter Employee ID to delete");
	   int id = sc.nextInt();
	   
	  Session session = factory.openSession();
	  
	Transaction trans = session.beginTransaction();
	 
	   Employee e = (Employee)session.get("Employee.class",id);
	   if(e!=null) {
		   System.out.println(e);
		   System.out.println("Is Removed");
		   session.remove(e);
		   
		  trans.commit();
		  session.close();
		  
	   }else {
		   System.out.println("Invlalid employyee id");
	   }
	   
   }
}
