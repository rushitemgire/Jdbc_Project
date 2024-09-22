package com.jdbc.dao;

import java.util.List;

import com.jdbc.dto.Employee;

public interface EmployeeDAO {
	List getEmployees();
	Employee getEmployee(int id);
	boolean insertEmployee(int id, String name, String desig,int salary);
	boolean updateEmployee(Employee e);
	boolean deleteEmployee(int id);
	
	
	
}
