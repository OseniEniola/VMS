package com.example.demo.command;

import java.util.List;

import com.example.demo.model.Employee;
import com.example.demo.model.Meeting;
import com.example.demo.model.Visitor;

public class MCmd {
	private Employee emp;
	private Visitor vi;
 private List<Visitor> visitor;
 private  List<Employee> employee;
 private Meeting meeting;
public List<Visitor> getVisitor() {
	return visitor;
}
public void setVisitor(List<Visitor> visitor) {
	this.visitor = visitor;
}
public List<Employee> getEmployee() {
	return employee;
}
public void setEmployee(List<Employee> employee) {
	this.employee = employee;
}
public Meeting getMeeting() {
	return meeting;
}
public void setMeeting(Meeting meeting) {
	this.meeting = meeting;
}
public Employee getEmp() {
	return emp;
}
public void setEmp(Employee emp) {
	this.emp = emp;
}
public Visitor getVi() {
	return vi;
}
public void setVi(Visitor vi) {
	this.vi = vi;
}

 
 
 

}
