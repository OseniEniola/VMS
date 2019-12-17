package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VisitorsMeeting {
	@Id
	private Integer m_id;
	private Integer v_id;
	private String m_start;
	private String m_date;
	private String m_end;
	private String v_firstname;
	private String v_lastname;
	private String v_company;
	private String m_subject;
	private Integer v_status;
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public Integer getV_id() {
		return v_id;
	}
	public void setV_id(Integer v_id) {
		this.v_id = v_id;
	}
	public String getM_start() {
		return m_start;
	}
	public void setM_start(String m_start) {
		this.m_start = m_start;
	}
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}
	public String getM_end() {
		return m_end;
	}
	public void setM_end(String m_end) {
		this.m_end = m_end;
	}
	
	public String getV_company() {
		return v_company;
	}
	public void setV_company(String v_company) {
		this.v_company = v_company;
	}
	public String getM_subject() {
		return m_subject;
	}
	public void setM_subject(String m_subject) {
		this.m_subject = m_subject;
	}
	public Integer getV_status() {
		return v_status;
	}
	public void setV_status(Integer integer) {
		this.v_status = integer;
	}
	public String getV_firstname() {
		return v_firstname;
	}
	public void setV_firstname(String v_firstname) {
		this.v_firstname = v_firstname;
	}
	public String getV_lastname() {
		return v_lastname;
	}
	public void setV_lastname(String v_lastname) {
		this.v_lastname = v_lastname;
	}
	
	
	
	
	
}
