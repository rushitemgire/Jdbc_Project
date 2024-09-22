package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.jdbc.connector.ConnectorFactory;
import com.jdbc.dto.Employee;

public class EmployeeDAOimpl implements EmployeeDAO{
	
	LinkedList<Employee> emplist = null;
	public List getEmployees() {
		try {
			Connection con = ConnectorFactory.requestConnection();
			String query = "select * from employee";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			emplist = new LinkedList<Employee>();
			
			while(res.next())
			{
				int id = res.getInt(1);
				String name = res.getString(2);
				String desig = res.getString(3);
				int salary = res.getInt(4);
				
				Employee e = new Employee(id,name,desig,salary);
				emplist.add(e);
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emplist;

	}

	public Employee getEmployee(int id) {
		Employee e = null;
		try
		{
			Connection con = ConnectorFactory.requestConnection();
			String query = "select * from employee where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			res.next();
			e = new Employee(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4));
		}
		catch (Exception e2)
		{
			e2.printStackTrace();
		}
		return e;
	}

	public boolean insertEmployee(int id, String name, String desig, int salary) {
		try
		{
			Connection con = ConnectorFactory.requestConnection();
			String query = "INSERT INTO employee (id, name, desig, salary) VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, desig);
			pstmt.setInt(4, salary);
//			System.out.println(pstmt.executeQuery());
			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected>0;
		}
		catch (Exception e2)
		{
			e2.printStackTrace();
		}
		
		return false;
	}

	public boolean updateEmployee(Employee e) {
		int i = 0;
		try
		{
			Connection con = ConnectorFactory.requestConnection();
			String query = "update employee set salary = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, e.getSalary());
			pstmt.setInt(2, e.getId());
			i = pstmt.executeUpdate();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		if(i!=0)
		{
			return true;
		}
		return false;
	}

    public boolean deleteEmployee(int id) {
        try {
            Connection con = ConnectorFactory.requestConnection();
            String query = "delete from employee where id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }
}
