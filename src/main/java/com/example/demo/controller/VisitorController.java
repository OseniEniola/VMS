package com.example.demo.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.command.EmpCommand;
import com.example.demo.command.VisitorCommand;
import com.example.demo.dao.VisitorRepo;
import com.example.demo.model.Employee;
import com.example.demo.model.Visitor;
import com.example.demo.services.VisitorsServices;

import org.springframework.ui.*;

@Controller
public class VisitorController {
	@Autowired
	VisitorRepo v_repo;
	@Autowired
	VisitorsServices vs;
	
	@RequestMapping("/reg_visitor")
	public String visitorRegform(Model m) {
		VisitorCommand vcmd=new VisitorCommand();
		m.addAttribute("command", vcmd);
		return "visitor_form";
	}
	
	@RequestMapping("/visitor/edit_visitor")
	public String editVisitor(@RequestParam ("vid") Integer vid, Model m, HttpSession session) {
		session.setAttribute("vid", vid);
		Visitor v= v_repo.findByVid(vid);
		VisitorCommand vcmd = new VisitorCommand();
		vcmd.setVcmd(v);
		m.addAttribute("command", vcmd);
		return "visitor_form";
	}
	
	@RequestMapping("/addvisitor")
	public String addVisitor(@ModelAttribute ("command") VisitorCommand vc, Model m,HttpSession session) {
		Integer v= (Integer)session.getAttribute("vid");
		System.out.println("Visitor ID is: "+v);
		if(v== null) {
			Visitor visit= new Visitor();
			visit=vc.getVcmd();
			visit.setStatus(vs.LOGIN_STATUS_ACVTIVE);
			v_repo.save(visit);
			return "visitor_form";
		}else {
			vc.getVcmd().setVid(v);
			vc.getVcmd().setStatus(vs.LOGIN_STATUS_ACVTIVE);
			v_repo.save(vc.getVcmd());
			session.invalidate();
			return "redirect:/visitor";
		}
	}
	@RequestMapping("/visitor")
	public String visitorList(Model m) {
		List<Visitor> vlist=v_repo.findAll();
		m.addAttribute("v_list", vlist);
		return "visitorUI";
	}
}
