package com.jdbc.connector;

import java.util.List;
import java.util.Scanner;

import com.jdbc.dao.EmployeeDAOimpl;
import com.jdbc.dto.Employee;

public class DaoDriver {

	public static void main(String[] args) {
		EmployeeDAOimpl eDAOimpl = new EmployeeDAOimpl();
		List<Employee> employees = eDAOimpl.getEmployees();
		Scanner s = new Scanner(System.in);
		
		for(;;)
		{
			System.out.println("Enter 1 to view table\nEnter 2 to insert employee\nEnter 3 to update salary of employee\nEnter 4 to delete employee \nEnter 5 to terminate");
			int action = s.nextInt();
			switch(action)
			{
				case 1:
					for(Employee e : employees)
					{
						System.out.println(e);
					}
					System.out.println();
					break;
				
				case 2:
					System.out.println("Enter id, name, desig, salary of an employee: ");
					int newId = s.nextInt();
					String newName = s.next();
					String newDesig = s.next();
					int newSalari = s.nextInt();
					boolean Inserted = eDAOimpl.insertEmployee(newId, newName, newDesig, newSalari);
					System.out.println("Employee insertion " + (Inserted ? "successful\n" : "failed\n"));
					break;
					
				case 3:
					System.out.println("Enter employee Id to be updated: ");
					int id = s.nextInt();
					Employee e = eDAOimpl.getEmployee(id);
					System.out.println(e);
					
					System.out.println("Enter the salary to be updated: ");
					int newSalary = s.nextInt();
					e.setSalary(newSalary);
					boolean Update = eDAOimpl.updateEmployee(e);
					System.out.println("Employee salary updation " + (Update ? "successful\n" : "failed\n"));
					break;
					
				case 4:
					System.out.println("Enter id to delete the employee: ");
					int Id = s.nextInt();
					boolean Delete = eDAOimpl.deleteEmployee(Id);
					System.out.println("Employee deletion " + (Delete ? "successful\n" : "failed\n"));
					break;
				
				case 5:
					System.out.println("Program Terminated");
					System.exit(0);
					break;
				default:
					System.out.println("Give valid input\n");
			}
			
		}
	}

}
