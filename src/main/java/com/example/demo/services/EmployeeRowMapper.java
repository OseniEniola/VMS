package com.example.demo.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Employee;


public class EmployeeRowMapper implements RowMapper<Employee> {
	
	public Employee mapRow(ResultSet rs,int rowNum) throws SQLException {
		Employee e= new Employee();
		e.setE_Id(rs.getInt("e_id"));
		e.setE_firstname(rs.getString("e_firstname"));
		e.setE_lastname(rs.getString("e_lastname"));
		e.setE_email(rs.getString("e_email"));
		e.setE_phone(rs.getString("e_phone"));
		e.setErole(rs.getInt("erole"));
		e.setE_img(rs.getString("e_img"));
		e.setE_department(rs.getString("e_department"));
		e.setE_password(rs.getString("e_password"));
		
		return e;
	}
}
