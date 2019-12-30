package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Visitor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer vid;
private String v_firstname;
private String v_phone;
private String v_email;
private String v_address;
private String v_lastname;
private String v_img;
private String v_company;
private Integer status;


public Integer getVid() {
	return vid;
}
public void setVid(Integer vid) {
	this.vid = vid;
}
public String getV_firstname() {
	return v_firstname;
}
public void setV_firstname(String v_firstname) {
	this.v_firstname = v_firstname;
}
public String getV_phone() {
	return v_phone;
}
public void setV_phone(String v_phone) {
	this.v_phone = v_phone;
}
public String getV_email() {
	return v_email;
}
public void setV_email(String v_email) {
	this.v_email = v_email;
}
public String getV_address() {
	return v_address;
}
public void setV_address(String v_address) {
	this.v_address = v_address;
}
public String getV_lastname() {
	return v_lastname;
}
public void setV_lastname(String v_lastname) {
	this.v_lastname = v_lastname;
}
public String getV_img() {
	return v_img;
}
public void setV_img(String v_img) {
	this.v_img = v_img;
}
public String getV_company() {
	return v_company;
}
public void setV_company(String v_company) {
	this.v_company = v_company;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}


}
