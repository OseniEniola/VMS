package com.example.demo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.command.EmpCommand;
import com.example.demo.command.MCmd;
import com.example.demo.command.MeetingCommand;
import com.example.demo.command.VisitorCommand;
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
import com.example.demo.services.VisitorRowMapper;

import org.springframework.ui.*;
import org.springframework.util.StringUtils;

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
	public String addMeeting(@ModelAttribute ("mModel") MCmd meet, Model m, HttpSession session/*, @RequestParam("eid") String name*/ ) {
		Meeting mt= new Meeting();
		mt=meet.getMeeting();
		
		Employee e= new Employee();
		String[] tokens= StringUtils.split(meet.getEmp().getE_firstname(), " ");
		String eName= tokens[0];
		String eLastName=tokens[1];
		
		Visitor v= new Visitor();
		String[] visitortokens= StringUtils.split(meet.getVi().getV_firstname(), " ");
		String vName= visitortokens[0];
		String vLastName=visitortokens[1];
		
		String vSql= "SELECT v_id, v_address, v_email, v_firstname, v_img, v_lastname, v_phone, status, v_company FROM visitor WHERE v_firstname=? and v_lastname=?";
		Map vmap= new HashMap();
		vmap.put("v_firstname", vLastName);
		vmap.put("v_lastname", vName);
		v=(Visitor)temp.queryForObject(vSql, vmap.values().toArray(), new VisitorRowMapper());
		
		String sql="SELECT e_id, e_email,e_department,e_firstname,e_password,e_lastname,e_phone,erole, e_img FROM employee WHERE e_firstname=? AND e_lastname=?";
		Map mp= new HashMap();
		mp.put("e_firstname", eName);
		mp.put("e_lastname", eLastName);

		e=(Employee) temp.queryForObject(sql, mp.values().toArray(),new EmployeeRowMapper());
		
	//	mt.setM_host(session.getAttribute("e_fistname").toString());
		mt.setM_status("Active");
		m_repo.save(mt);
		
		//Employee meeting Details
		EmpMeeting em=new  EmpMeeting();
		em.setE_id(( e.getE_Id()));
		em.setE_department((e.getE_department()));
		em.setE_name((e.getE_firstname()));
		if(e.getErole()==es.LOGIN_STATUS_ACVTIVE) {
			em.setE_status("Active");
		}else {
			em.setE_status("Blocked");
		}
		em.setM_date(meet.getMeeting().getM_date());
		em.setM_id(meet.getMeeting().getM_id());
		em.setM_start(meet.getMeeting().getM_start_time());
		em.setM_end(meet.getMeeting().getM_end_time());
		em.setM_subject(meet.getMeeting().getM_subject());
		em_repo.save(em);
		
		//Visitors meeting details
		VisitorsMeeting vm=new VisitorsMeeting();
		vm.setV_id(v.getV_id());
		vm.setV_firstname(v.getV_firstname());
		vm.setV_lastname(v.getV_lastname());
		vm.setV_company(v.getV_company());
		vm.setV_status(v.getStatus());
		vm.setM_date(meet.getMeeting().getM_date());
		vm.setM_end(meet.getMeeting().getM_end_time());
		vm.setM_id(meet.getMeeting().getM_id());
		vm.setM_start(meet.getMeeting().getM_start_time());
		vm.setM_subject(meet.getMeeting().getM_subject());
		vm_repo.save(vm);
		return "redirect:/admin";
		
	}
	@RequestMapping("/meetingList")
	public String meetingList(Model m) {
	List<Meeting>	meetingList= m_repo.findAll();
		m.addAttribute("m_list", meetingList);
		return"meetingUI";
	}
}
