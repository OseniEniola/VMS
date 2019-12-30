package com.example.demo.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Visitor;

public class VisitorRowMapper implements RowMapper<Visitor> {
 public Visitor mapRow(ResultSet rs, int rowNum) throws SQLException {
	 Visitor v= new Visitor();
	 v.setVid(rs.getInt("vid"));
	 v.setV_firstname(rs.getString("v_firstname"));
	 v.setV_lastname(rs.getString("v_lastname"));
	 v.setV_address(rs.getString("v_address"));
	 v.setV_email(rs.getString("v_email"));
	 v.setV_img(rs.getString("v_img"));
	 v.setV_phone(rs.getString("v_phone"));
	 v.setStatus(rs.getInt("status"));
	 v.setV_company(rs.getString("v_company"));
	 
	 return v;
 }
}
