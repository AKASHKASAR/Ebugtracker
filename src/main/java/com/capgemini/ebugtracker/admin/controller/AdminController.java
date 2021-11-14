/*
  This is admin controller
 */
package com.capgemini.ebugtracker.admin.controller;

import com.capgemini.ebugtracker.admin.entity.StaffStatus;
import com.capgemini.ebugtracker.admin.service.AdminServices;
import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.capgemini.ebugtracker.bugs.servies.BugServices;
import com.capgemini.ebugtracker.staff.entity.Staff;
import com.capgemini.ebugtracker.staff.repositery.StaffDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author v62
 *
 */
@RestController
public class AdminController<String> {
    @Autowired
	private BugServices bugservices;
	@Autowired
	private AdminServices adminServices;
	@Autowired
	private StaffDao staffdao;

	public AdminController() {
	}


	@GetMapping("/adminhome")
	public String adminHome(){
		var string = (String) "This is Admin Home Page";
		return string;
		
	}
	
	//Get new arrived bug details
	@GetMapping("/getbuglist")
	public List<Bugs> getBugs(){
		return this.bugservices.getBugs();
		
	}


	//Get staff details
	@GetMapping("/getStaffList")
	public List<StaffStatus> getStaff(){
		return staffdao.getStaffList();
		
	}
	
	@PostMapping("/addstaff")
	public Staff addNewStaff(@RequestBody Staff staff){
		return this.adminServices.addNewStaff(staff);
		
	}
	
	@PutMapping("/assignbug")
	public Boolean assignBug( @RequestBody Long bugid, @RequestBody Long staffid ) {
		adminServices.assignBug(bugid,staffid);
		return true;
		
	}
	
	
}
