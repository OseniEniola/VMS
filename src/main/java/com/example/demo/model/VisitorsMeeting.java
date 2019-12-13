package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VisitorsMeeting {
	@Id
	private Integer m_id;
	private String v_id;
	private String m_stART;
	private String m_date;
	private String v_name;
	private String v_lastname;
	private String m_subject;
	private String v_status;
	
	
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public String getV_id() {
		return v_id;
	}
	public void setV_id(String v_id) {
		this.v_id = v_id;
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
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public String getV_lastname() {
		return v_lastname;
	}
	public void setV_lastname(String v_lastname) {
		this.v_lastname = v_lastname;
	}
	public String getM_subject() {
		return m_subject;
	}
	public void setM_subject(String m_subject) {
		this.m_subject = m_subject;
	}
	public String getV_status() {
		return v_status;
	}
	public void setV_status(String v_status) {
		this.v_status = v_status;
	}
}
