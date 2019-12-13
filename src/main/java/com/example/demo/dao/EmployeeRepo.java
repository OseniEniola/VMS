package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	List<Employee> findByErole(Integer roleUser);



}
