package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmpMeeting {
@Id
private Integer m_id;
private Integer e_id;
private String m_stART;
private String m_date;
private String e_name;
private String e_lastname;
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
public void setE_id(Integer v_id) {
	this.e_id = v_id;
}
public String getM_stART() {
	return m_stART;
}
public void setM_stART(String m_stART) {
	this.m_stART = m_stART;
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
public void setE_name(String v_name) {
	this.e_name = v_name;
}
public String getE_lastname() {
	return e_lastname;
}
public void setE_lastname(String v_lastname) {
	this.e_lastname = v_lastname;
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
public void setE_status(String v_status) {
	this.e_status = v_status;
}

}
