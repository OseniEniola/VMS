package com.example.demo.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.exception.UserBlockedException;
import com.example.demo.model.Employee;

@Service
public class EmployeeServices {

	public static final Integer LOGIN_STATUS_ACVTIVE=1;
	public static final Integer  LOGIN_STATUS_BLOCKED=2;
	public static final Integer ROLE_ADMIN=1;
	public static final Integer ROLE_USER=2;
	
	@Autowired
	JdbcTemplate temp;

	public Employee loginEmail(String username, String password) throws UserBlockedException {
		String sql="SELECT eid, e_email, e_department, e_firstname, e_password, e_lastname, e_phone, erole, e_img FROM employee WHERE e_email=? AND "
				+ "e_password=?";
		Map m= new HashMap();
		m.put("e_email",username);
		m.put("e_password",password);
		try {
			Employee e= (Employee) temp.queryForObject(sql, m.values().toArray(), new EmployeeRowMapper());
			return e;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		
	}
	public Employee loginphone(String phone, String password) throws UserBlockedException {
		String sql="SELECT eid, e_email, e_department, e_firstname, e_password, e_lastname, e_phone, erole, e_img FROM employee WHERE e_phone=? AND "
				+ "e_password=?";
		Map m= new HashMap();
		m.put("e_phone",phone);
		m.put("e_password",password);
		try {
			Employee e= (Employee) temp.queryForObject(sql, m.values().toArray(), new EmployeeRowMapper());
			return e;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		
	}
	
}
