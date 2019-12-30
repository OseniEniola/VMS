package com.example.demo.services;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;

import com.example.demo.command.MCmd;
import com.example.demo.dao.EmpMeetingRepo;
import com.example.demo.dao.MeetingRepo;
import com.example.demo.dao.VisitorMeetingRepo;
import com.example.demo.model.EmpMeeting;
import com.example.demo.model.Employee;
import com.example.demo.model.Meeting;
import com.example.demo.model.Visitor;
import com.example.demo.model.VisitorsMeeting;

@Service
public class MeetingServices {
	public static final Integer LOGIN_STATUS_ACVTIVE=1;
	public static final Integer  LOGIN_STATUS_BLOCKED=2;
	public static final Integer ROLE_ADMIN=1;
	public static final Integer ROLE_USER=2;
	
	@Autowired
	EmpMeetingRepo em_repo;
	@Autowired
	MeetingRepo m_repo;
	@Autowired 
	JdbcTemplate temp;
	@Autowired
	private JavaMailSender sender;
	@Autowired
	EmployeeServices es;
	@Autowired
	VisitorMeetingRepo vm_repo;
	
	@Async("asyncExecutor")
	public CompletableFuture<List<Meeting>> findMeetings() throws InterruptedException{
		System.out.println("Execte Method asynchronously "+ Thread.currentThread().getName());

		//logger.info("Looking up meetings");
		RestTemplate restTemplate = null;
		List<Meeting> meet= m_repo.findAll();
		Thread.sleep(1000L);
		return CompletableFuture.completedFuture(meet);
	}
	
	@Async("asyncExecutor")
	public void addemp(@ModelAttribute ("mModel") MCmd meet) {
		System.out.println("Execte Method asynchronously "+ Thread.currentThread().getName());

		Employee e= new Employee();
		String[] tokens= StringUtils.split(meet.getEmp().getE_firstname(), " ");
		String eName= tokens[0];
		String eLastName=tokens[1];
		
		String sql="SELECT e_id, e_email,e_department,e_firstname,e_password,e_lastname,e_phone,erole, e_img FROM employee WHERE e_firstname=? AND e_lastname=?";
		Map mp= new HashMap();
		mp.put("e_firstname", eName);
		mp.put("e_lastname", eLastName);

		e=(Employee) temp.queryForObject(sql, mp.values().toArray(),new EmployeeRowMapper());
		//Employee meeting Details
				EmpMeeting em=new  EmpMeeting();
				em.setE_id(( e.getEid()));
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
	}
	// Add visitor details to visitor meeting table
	@Async("asyncExecutor")
	public void addVisitor(@ModelAttribute ("mModel") MCmd meet) {
		System.out.println("Execte Method asynchronously "+ Thread.currentThread().getName());

		Visitor v= new Visitor();
		String[] visitortokens= StringUtils.split(meet.getVi().getV_firstname(), " ");
		String vName= visitortokens[0];
		String vLastName=visitortokens[1];
		
		String vSql= "SELECT v_id, v_address, v_email, v_firstname, v_img, v_lastname, v_phone, status, v_company FROM visitor WHERE v_firstname=? and v_lastname=?";
		Map vmap= new HashMap();
		vmap.put("v_firstname", vLastName);
		vmap.put("v_lastname", vName);
		v=(Visitor)temp.queryForObject(vSql, vmap.values().toArray(), new VisitorRowMapper());

		//Visitors meeting details
		VisitorsMeeting vm=new VisitorsMeeting();
		vm.setV_id(v.getVid());
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
		
	}
	
	@Async
	public void sendEmail(@ModelAttribute ("mModel") MCmd m, HttpSession session,Visitor v, Employee e) throws Exception{
		MimeMessage message= sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		helper.setTo(e.getE_email());
		helper.setTo(v.getV_email());
		helper.setText("You are scheduled for the "+m.getMeeting().getM_subject()+" meeting at "+m.getMeeting().getM_venue()+" "
				+ "with meeting purpose "+m.getMeeting().getM_purpose()+""
				+ " at "+m.getMeeting().getM_start_time()+""
				+ " you can check in with your phone number:"+v.getV_phone()+" or your email:"+v.getV_email()+".");
		helper.setSubject("Meeting Notification from eniola");
		
		sender.send(message);
	}
}
