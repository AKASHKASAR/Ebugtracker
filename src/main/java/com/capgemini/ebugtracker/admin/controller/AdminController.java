/*
  This is admin controller
 */
package com.capgemini.ebugtracker.admin.controller;

import com.capgemini.ebugtracker.admin.service.AdminServices;
import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.capgemini.ebugtracker.bugs.servies.BugServices;
import com.capgemini.ebugtracker.staff.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Map;

/**
 * @author v62
 *
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
   
	 @Autowired
		private BugServices bugservices;
		
		@Autowired
		private AdminServices adminServices;
//		@Autowired
//		private StaffDao staffdao;
//

		
		@GetMapping("/adminhome")
		public String adminHome(){
			return "Tis is Home Admin Homepage";
			
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
		public Staff addNewStaff(@RequestBody Staff staff) throws MessagingException {
			this.adminServices.addNewStaff(staff);
			try {
					this.adminServices.addNewStaff(staff);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				return staff;
			}


			//Assign bug to staff
			@PutMapping("/assignbug/{bugid}/{staffid}")
			public String assignBug(@PathVariable("bugid") Long bugid,@PathVariable("staffid") Long staffid ){
				
				adminServices.assignBug(bugid,staffid);
				return "Bug is assigned to staff";
//			
		}
		@PostMapping("/sendMessage")
		public String sendMessage(@RequestBody Bugs bug) {
			
			this.adminServices.sendMessage(bug);
			
			return "Message Sent to Customer";
			
		}
		
}
