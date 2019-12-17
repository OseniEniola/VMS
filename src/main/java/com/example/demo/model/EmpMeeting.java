package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmpMeeting {
@Id
private Integer m_id;
private Integer e_id;
private String m_start;
private String m_end;
private String m_date;
private String e_name;
private String e_department;
private String m_subject;
private String e_status;
public Integer getM_id() {
	return m_id;
}
public void setM_id(Integer m_id) {
	this.m_id = m_id;
}
public Integer getE_id() {
	return e_id;
}
public void setE_id(Integer e_id) {
	this.e_id = e_id;
}
public String getM_start() {
	return m_start;
}
public void setM_start(String m_start) {
	this.m_start = m_start;
}
public String getM_end() {
	return m_end;
}
public void setM_end(String m_end) {
	this.m_end = m_end;
}
public String getM_date() {
	return m_date;
}
public void setM_date(String m_date) {
	this.m_date = m_date;
}
public String getE_name() {
	return e_name;
}
public void setE_name(String e_name) {
	this.e_name = e_name;
}
public String getE_department() {
	return e_department;
}
public void setE_department(String e_department) {
	this.e_department = e_department;
}
public String getM_subject() {
	return m_subject;
}
public void setM_subject(String m_subject) {
	this.m_subject = m_subject;
}
public String getE_status() {
	return e_status;
}
public void setE_status(String e_status) {
	this.e_status = e_status;
}




}
