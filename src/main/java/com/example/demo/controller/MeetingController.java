package com.example.demo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.mail.javamail.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.demo.command.MCmd;
import com.example.demo.dao.EmpMeetingRepo;
import com.example.demo.dao.EmployeeRepo;
import com.example.demo.dao.MeetingRepo;
import com.example.demo.dao.VisitorMeetingRepo;
import com.example.demo.dao.VisitorRepo;
import com.example.demo.model.EmpMeeting;
import com.example.demo.model.Employee;
import com.example.demo.model.Meeting;
import com.example.demo.model.Visitor;
import com.example.demo.model.VisitorsMeeting;
import com.example.demo.services.EmployeeRowMapper;
import com.example.demo.services.EmployeeServices;
import com.example.demo.services.MeetingServices;
import com.example.demo.services.VisitorRowMapper;

import ch.qos.logback.classic.Logger;

import javax.mail.internet.*;
@Controller

public class MeetingController {
	@Autowired
	EmployeeServices es;
	@Autowired
	EmployeeRepo e_repo;
	@Autowired
	VisitorRepo v_repo;
	@Autowired
	MeetingRepo m_repo;
	@Autowired
	EmpMeetingRepo em_repo;
	@Autowired
	VisitorMeetingRepo vm_repo;
	@Autowired 
	JdbcTemplate temp;
	@Autowired
	private JavaMailSender sender;
	@Autowired
	MeetingServices ms;

	@RequestMapping("/add_meeting")
	public String addMeetingForm(Model m) {
		
		MCmd mm= new MCmd();
		
		List<Employee> e;
		e=e_repo.findAll();
		mm.setEmployee(e);
		
		List<Visitor> v;
		v=v_repo.findAll();
		mm.setVisitor(v);
		
		m.addAttribute("mModel", mm);
		m.addAttribute("empList", e);
		m.addAttribute("visitList", v);
		return "meeting_form";
		
	}
	
	
	
	@RequestMapping("/addMeeting")
	public String addMeeting(@ModelAttribute ("mModel") MCmd meet, Model m, HttpSession session ) throws Exception {
		Meeting mt= new Meeting();
		mt=meet.getMeeting();
		//mt.setM_host(session.getAttribute("e_fistname").toString()+" "+session.getAttribute("e_lastname").toString());
		mt.setM_status("Active");
		m_repo.save(mt);
		
		Employee e= new Employee();
		String[] tokens= StringUtils.split(meet.getEmp().getE_firstname(), " ");
		String eName= tokens[0];
		String eLastName=tokens[1];
		
		String sql="SELECT e_id, e_email,e_department,e_firstname,e_password,e_lastname,e_phone,erole, e_img FROM employee WHERE e_firstname=? AND e_lastname=?";
		Map mp= new HashMap();
		mp.put("e_firstname", eName);
		mp.put("e_lastname", eLastName);
		e=(Employee) temp.queryForObject(sql, mp.values().toArray(),new EmployeeRowMapper());

		
		Visitor v= new Visitor();
		String[] visitortokens= StringUtils.split(meet.getVi().getV_firstname(), " ");
		String vName= visitortokens[0];
		String vLastName=visitortokens[1];
		
		String vSql= "SELECT v_id, v_address, v_email, v_firstname, v_img, v_lastname, v_phone, status, v_company FROM visitor WHERE v_firstname=? and v_lastname=?";
		Map vmap= new HashMap();
		vmap.put("v_firstname", vLastName);
		vmap.put("v_lastname", vName);
		v=(Visitor)temp.queryForObject(vSql, vmap.values().toArray(), new VisitorRowMapper());
		
		
		
		ms.findMeetings();
		ms.addVisitor(meet);
		ms.addemp(meet);
		ms.sendEmail(meet,session,v,e);
		
		return "redirect:/admin";
		
	}
	// Add Employee details to employee meeting table
	
	@RequestMapping("/meetingList")
	public String meetingList(Model m) {
	List<Meeting>	meetingList= m_repo.findAll();
		m.addAttribute("m_list", meetingList);
		return"meetingUI";
	}
}
