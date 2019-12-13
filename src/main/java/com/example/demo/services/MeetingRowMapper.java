package com.example.demo.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Meeting;

public class MeetingRowMapper implements RowMapper<Meeting> {
 public Meeting mapRow(ResultSet rs, int rowNum) throws SQLException {
	 Meeting m=new Meeting();
	 m.setM_id(rs.getInt("m_id"));
	 m.setM_subject(rs.getString("m_subject"));
	 m.setM_purpose(rs.getString("m_purpose"));
	 m.setM_venue(rs.getString("m_venue"));
	 m.setM_start_time(rs.getString("m_start_time"));
	 m.setM_end_time(rs.getString("m_end_time"));
	 m.setM_date(rs.getString("m_date"));
	 m.setM_host(rs.getString("m_host"));
	 m.setM_status(rs.getString(",_status"));
	 
	 return m;
 }
}
