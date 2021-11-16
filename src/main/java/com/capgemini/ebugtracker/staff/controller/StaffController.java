package com.capgemini.ebugtracker.staff.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ebugtracker.admin.service.AdminServices;
import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.capgemini.ebugtracker.staff.entity.ForwardBug;
import com.capgemini.ebugtracker.staff.services.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController<String> {
	@Autowired
	private AdminServices adminservices;
	@Autowired
	private StaffService staffservices;
	
	
	@GetMapping("/staffhome")
	public String staffHome(){
		return (String) "Welcome to Staff Home Page";

	}
	
	//Get all assigned bug details
	@GetMapping("/allAssignedBug")
	public List<Bugs> getBugs(@RequestBody Long staffid){
		return this.staffservices.getBugs(staffid);
		
	}
	
	//Send three ids currentstaffid, bugid and staffid
	@PutMapping("/forwardBug")
	public void forwardBug(@RequestBody ForwardBug forwordbug ){
		staffservices.forwardBug(forwordbug);
		//staffservices.forwardBug(Long.parseLong(bugid),Long.parseLong(staffid));
		
	}
	
	
	@GetMapping("/sendMessage")
	public String sendMesage(@RequestBody Bugs bug) {
		
		this.adminservices.sendMessage(bug);
		
		return (String) "Message Sent";
		
	}
	
	
	
	
}