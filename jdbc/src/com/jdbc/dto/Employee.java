package com.jdbc.dto;

public class Employee {
	private int id;
	private String name;
	private String desig;
	private int salary;
	
	private Employee()
	{
		
	}
	
	public Employee(int id, String name, String desig, int salary) 
	{
		super();
		this.id = id;
		this.name = name;
		this.desig = desig;
		this.salary = salary;
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

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String toString()
	{
		return id + "\t" + name + "\t" + desig + "\t" + salary;
	}
	
	
}
