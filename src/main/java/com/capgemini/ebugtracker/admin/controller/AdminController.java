/**
 * 
 */
package com.capgemini.ebugtracker.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.capgemini.ebugtracker.bugs.servies.*;
import com.capgemini.ebugtracker.staff.entity.Staff;
import com.capgemini.ebugtracker.staff.services.StaffService;
/**
 * @author v62
 *
 */
@RestController
public class AdminController<String> {
	
	private BugServices bugservices;
	
	private StaffService staffservices;
	
	
	@GetMapping("/adminhome")
	public String adminHome(){
		return (String) "This is Admin Home Page";
		
	}
	
	//Get new arrived bug details
	@GetMapping("/getBugList")
	public List<Bugs> getBugs(){
		return this.bugservices.getBugs();
		
	}
	
		
	//Get staff details
	@GetMapping("/getStaffList")
	public List<Staff> getStaff(Staff staff){
		return null;
		
	}
	
	@PostMapping("/addStaff")
	public Staff addNewStaff(@RequestBody Staff staff){
		return this.staffservices.addNewStaff(staff);
		
	}
	
	@PutMapping("/assignBug")
	public Boolean assignBug(){
		return null;
		
	}
	
	
}
