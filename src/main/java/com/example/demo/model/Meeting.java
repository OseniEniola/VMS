package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meeting {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private Integer m_id;
private String m_subject;
private String m_purpose;
private String m_venue;
private String m_date;
private String m_start_time;
private String m_end_time;
private String m_host;
private String m_status;

public Integer getM_id() {
	return m_id;
}
public void setM_id(Integer m_id) {
	this.m_id = m_id;
}
public String getM_subject() {
	return m_subject;
}
public void setM_subject(String m_subject) {
	this.m_subject = m_subject;
}
public String getM_purpose() {
	return m_purpose;
}
public void setM_purpose(String m_purpose) {
	this.m_purpose = m_purpose;
}
public String getM_venue() {
	return m_venue;
}
public void setM_venue(String m_venue) {
	this.m_venue = m_venue;
}
public String getM_date() {
	return m_date;
}
public void setM_date(String m_date) {
	this.m_date = m_date;
}
public String getM_start_time() {
	return m_start_time;
}
public void setM_start_time(String m_start_time) {
	this.m_start_time = m_start_time;
}
public String getM_end_time() {
	return m_end_time;
}
public void setM_end_time(String m_end_time) {
	this.m_end_time = m_end_time;
}
public String getM_host() {
	return m_host;
}
public void setM_host(String m_host) {
	this.m_host = m_host;
}
public String getM_status() {
	return m_status;
}
public void setM_status(String m_status) {
	this.m_status = m_status;
}


}
