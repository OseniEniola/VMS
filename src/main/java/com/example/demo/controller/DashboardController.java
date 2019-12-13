package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.command.EmpCommand;
import com.example.demo.command.LoginCmd;
import com.example.demo.dao.EmployeeRepo;
import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeServices;

@Controller
public class DashboardController {
	@Autowired
	EmployeeServices es;
	@Autowired
	EmployeeRepo e_repo;
	
	@RequestMapping("/vms")
	public String loginPage(Model m) {
		LoginCmd cmd= new LoginCmd();
		m.addAttribute("login",cmd);
		return "index";
		}
	
	@RequestMapping("/reg_form")
	public String registerEmp(Model m) {
		EmpCommand emp= new EmpCommand();
		m.addAttribute("command", emp);
		return "reg_form";
	}
	@RequestMapping("/register")
	public String registerEmp(@ModelAttribute ("command") EmpCommand empCommand, Model m) {
		Employee e=new Employee();
		e=empCommand.getEmp();
		e.setErole(es.ROLE_USER);
		e_repo.save(e);
		return "redirect:/vms?act=reg";
	}
	@RequestMapping("/admin")
	public String adminDashboard(Model m) {
		List<Employee> emplist= e_repo.findByErole(es.ROLE_USER);
		m.addAttribute("emplist", emplist);
		return "adminUI";
	}
}
