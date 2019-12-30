package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer eid;
	private String E_firstname;
	private String E_lastname;
	private String E_phone;
	private String E_email;
	private Integer erole;
	private String E_password;
	private String E_department;
	private String E_img;
	
	
	public String getE_password() {
		return E_password;
	}
	public void setE_password(String e_password) {
		E_password = e_password;
	}
	
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getE_firstname() {
		return E_firstname;
	}
	public void setE_firstname(String e_firstname) {
		E_firstname = e_firstname;
	}
	public String getE_lastname() {
		return E_lastname;
	}
	public void setE_lastname(String e_lastname) {
		E_lastname = e_lastname;
	}
	public String getE_phone() {
		return E_phone;
	}
	public void setE_phone(String e_phone) {
		E_phone = e_phone;
	}
	public String getE_email() {
		return E_email;
	}
	public void setE_email(String e_email) {
		E_email = e_email;
	}
	public Integer getErole() {
		return erole;
	}
	public void setErole(Integer erole) {
		this.erole = erole;
	}
	public String getE_img() {
		return E_img;
	}
	public void setE_img(String e_img) {
		E_img = e_img;
	}
	public String getE_department() {
		return E_department;
	}
	public void setE_department(String e_department) {
		E_department = e_department;
	}
	

	
	

}
