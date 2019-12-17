package com.example.demo.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.command.LoginCmd;
import com.example.demo.dao.EmployeeRepo;
import com.example.demo.exception.UserBlockedException;
import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeServices;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeServices es;
	@Autowired
	EmployeeRepo e_repo;
	
	@RequestMapping("/login")
	public String loginEmp(@ModelAttribute ("login") LoginCmd cmd, Model m, HttpSession sesion) {
		if(cmd.getUsername().contains("@")) {
		try { 
			Employee loggedemp= es.loginEmail(cmd.getUsername(), cmd.getPassword());
			if(loggedemp==null) {
				m.addAttribute("ex", "Login Failed Enter valid credentials");
				return "/vms";
			}
			else if(loggedemp.getErole()==es.ROLE_USER) {
				addUserInSession(loggedemp,sesion);
				m.addAttribute("wel", "Welcome");
				return "redirect:/admin?act=wel";
			}
		}catch(UserBlockedException ex) {
			return null;
		}
		}else {
			try {
			Employee loggedemp= es.loginphone(cmd.getUsername(), cmd.getPassword());
			if(loggedemp==null) {
				m.addAttribute("ex", "Login Failed Enter valid credentials");
				return "adminUI";
			}
			else if(loggedemp.getErole()==es.ROLE_USER) {
				addUserInSession(loggedemp,sesion);
				m.addAttribute("wel", "Welcome");
				return "redirect:/admin?act=wel";
			}
		}catch(UserBlockedException ex) {
			return null;
		}
		}
		return "index";
	}
	@RequestMapping("/employee")
	public String adminDashboard(Model m) {
		List<Employee> emplist= e_repo.findByErole(es.ROLE_USER);
		m.addAttribute("emplist", emplist);
		return "adminUI";
	}
	
	public void addUserInSession(Employee e, HttpSession session) {
		session.setAttribute("employee", e);
		session.setAttribute("e_id", e.getE_Id());
		session.setAttribute("erole", e.getErole());
		session.setAttribute("e_firstname", e.getE_firstname());
		session.setAttribute("e_lastname", e.getE_lastname());
	}
	
}
