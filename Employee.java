package com.kodnest.EmployeeManagement;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int id;

@Column
String name;
@Column
int salary;
@Column
int password;
@Column
int age;

public Employee() {
	
}

public Employee(String name, int salary, int password, int age) {
	super();
	this.name = name;
	this.salary = salary;
	this.password = password;
	this.age = age;
}

public Employee(int id, String name, int salary, int password, int age) {
	super();
	this.id = id;
	this.name = name;
	this.salary = salary;
	this.password = password;
	this.age = age;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getSalary() {
	return salary;
}

public void setSalary(int salary) {
	this.salary = salary;
}

public int getPassword() {
	return password;
}

public void setPassword(int password) {
	this.password = password;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

@Override
public String toString() {
	return id+" "+name+" "+salary+" "+password+" ";
}

}
