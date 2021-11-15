/*
  This is admin controller
 */
package com.capgemini.ebugtracker.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ebugtracker.admin.service.AdminServices;
import com.capgemini.ebugtracker.bugs.servies.BugServices;
import com.capgemini.ebugtracker.staff.repositery.StaffDao;

/**
 * @author v62
 *
 */
@RestController
public class AdminController {
   
	@Autowired
	BugServices bugservices;
	@Autowired
	private AdminServices adminservices;
	
	private StaffDao staffdao;

	


	@GetMapping("/adminhome")
	public String adminHome(){
		var string = (String) "This is Admin Home Page";
		return string;
		
	}




	public BugServices getBugservices() {
		return bugservices;
	}




	public void setBugservices(BugServices bugservices) {
		this.bugservices = bugservices;
	}




	public AdminServices getAdminServices() {
		return adminservices;
	}




	public void setAdminServices(AdminServices adminServices) {
		this.adminservices = adminServices;
	}
	
//	//Get new arrived bug details
//	@GetMapping("/getbuglist")
//	public List<Bugs> getBugs(){
//		return this.bugservices.getBugs();
//		
//	}
//
//
//	//Get staff details
//	@GetMapping("/getStaffList")
//	public List<StaffStatus> getStaff(){
//		return staffdao.getStaffList();
//		
//	}
//	
//	@PostMapping("/addstaff")
//	public Staff addNewStaff(@RequestBody Staff staff){
//		return this.adminServices.addNewStaff(staff);
//		
//	}
//	
//	@PutMapping("/assignbug")
//	public Boolean assignBug( @RequestBody Long bugid, @RequestBody Long staffid ) {
//		adminServices.assignBug(bugid,staffid);
//		return true;
//		
//	}
//	
//	
}
