/*
  This is admin controller
 */
package com.capgemini.ebugtracker.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.capgemini.ebugtracker.staff.entity.Staff;
import com.capgemini.ebugtracker.admin.service.AdminServices;
import com.capgemini.ebugtracker.bugs.servies.BugServices;
import com.capgemini.ebugtracker.mailsender.Mailsender;
import com.capgemini.ebugtracker.staff.repositery.StaffDao;
import com.capgemini.ebugtracker.user.entity.Customer;
import com.capgemini.ebugtracker.user.repositery.UserDao;

import javax.mail.MessagingException;

/**
 * @author v62
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
   
	 @Autowired
		private BugServices bugservices;
		
		@Autowired
		private AdminServices adminServices;
		@Autowired
		private StaffDao staffdao;
		
		
		
		@GetMapping("/adminhome")
		public String adminHome(){
			var string = (String) "This is Admin Home Page";
			return string;
			
		}
		
		//Get new arrived bug details
	@GetMapping("/pendingBugList")
		public List<Bugs> getPendingBugs(){
		   
			return  this.bugservices.getPendingBugs();
			
		}

	//List of newly created bugs
	@GetMapping("/newBugList")
	public java.util.List<Bugs> getNewBug(){
		return bugservices.getNewBugs();
		
	}
		//Get list of all the completed bug 
		@GetMapping("/bugList")
		public java.util.List<Bugs> getBug(){
			return bugservices.getBugs();
			
		}
//		Add new staff
		@PostMapping("/addStaff")
		public Staff addNewStaff(@RequestBody Staff staff){
			try {
				this.adminServices.addNewStaff(staff);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			return staff;
			
		}
	//	
		//Assign bug to staff
		@PutMapping("/assignbug")
		public String assignBug(@RequestBody Map<String, String>  id ) {
			String bugid=id.get("bugid");
			String staffid=id.get("staffid");
			adminServices.assignBug(Long.parseLong(bugid),Long.parseLong(staffid));
			return "assined bug to  staff";
//			
		}
		@PostMapping("/sendMessage")
		public String sendMesage(@RequestBody Bugs bug) {
			
			this.adminServices.sendMessage(bug);
			
			return "Message Sent";
			
		}
		
}
