package com.example.demo.command;

import com.example.demo.model.Employee;
import com.example.demo.model.Meeting;
import com.example.demo.model.Visitor;

public class MCmd {
 private Visitor visitor;
 private Employee employee;
 private Meeting meeting;
 
 
public Visitor getVisitor() {
	return visitor;
}
public void setVisitor(Visitor visitor) {
	this.visitor = visitor;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
public Meeting getMeeting() {
	
	return meeting;
}
public void setMeeting(Meeting meeting) {
	this.meeting = meeting;
}
}
