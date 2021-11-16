package com.capgemini.ebugtracker.staff.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.capgemini.ebugtracker.staff.entity.ForwardBug;
import com.capgemini.ebugtracker.staff.services.StaffService;

@RestController
public class StaffController<String> {
	
	//private BugServices bugservices;
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
//		Long currentstaffid=Long.parseLong((java.lang.String) id.get("currentstaffId"));
//		Long bugid=Long.parseLong((java.lang.String) id.get("bugid"));
//		Long staffid=Long.parseLong((java.lang.String) id.get("staffId"));
		staffservices.forwardBug(forwordbug);
		//staffservices.forwardBug(Long.parseLong(bugid),Long.parseLong(staffid));
		
	}
	
	
}