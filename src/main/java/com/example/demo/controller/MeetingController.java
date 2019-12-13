package com.example.demo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.command.EmpCommand;
import com.example.demo.command.MCmd;
import com.example.demo.command.MeetingCommand;
import com.example.demo.command.VisitorCommand;
import com.example.demo.dao.EmployeeRepo;
import com.example.demo.dao.MeetingRepo;
import com.example.demo.dao.VisitorRepo;
import com.example.demo.model.Employee;
import com.example.demo.model.Meeting;
import com.example.demo.model.Visitor;
import com.example.demo.services.EmployeeServices;

import org.springframework.ui.*;

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

	@RequestMapping("/add_meeting")
	public String addMeetingForm(Model m) {
		List<Employee> e= e_repo.findAll();
		List<Visitor> v= v_repo.findAll();
		List<Meeting> mt= m_repo.findAll();
		MCmd mm= new MCmd();
		MeetingCommand meeting= new MeetingCommand();
		EmpCommand emp= new EmpCommand();
		VisitorCommand vi= new VisitorCommand();
		
		m.addAttribute("emp", emp);
		m.addAttribute("vi", vi);
		m.addAttribute("meeting", meeting);
		m.addAttribute("employee", e);
		m.addAttribute("visitor", v);
		m.addAttribute("meet", mt);
		m.addAttribute("mModel", mm);
		
		return "meeting_form";
		
	}
	@RequestMapping("/addMeeting")
	public String addMeeting(@ModelAttribute ("mModel") MCmd meet, Model m) {
		Meeting mt= new Meeting();
		mt=meet.getMeeting();
		Employee e= new Employee();
		e=meet.getEmployee();
		mt.setM_host("Eniola Oseni");
		mt.setM_status("Active");
		m_repo.save(mt);
		return null;
		
	}
}
