package com.capgemini.ebugtracker.staff.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ebugtracker.admin.service.AdminServices;
import com.capgemini.ebugtracker.bugs.entity.Bugs;
//import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.capgemini.ebugtracker.bugs.entity.Status;
import com.capgemini.ebugtracker.bugs.repositery.BugDao;
import com.capgemini.ebugtracker.staff.entity.ForwardBug;
import com.capgemini.ebugtracker.staff.entity.Staff;
import com.capgemini.ebugtracker.staff.entity.StatusLogin;
import com.capgemini.ebugtracker.staff.repositery.StaffDao;
import com.capgemini.ebugtracker.staff.services.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController<String> {
	@Autowired
	private AdminServices adminservices;
	@Autowired
	private StaffService staffservices;
	
	@Autowired
	private StaffDao staffdao;
	
	@Autowired
	private BugDao bugdao;
	
	@PostMapping("/login")
    public StatusLogin loginStaff(@Validated @RequestBody Staff staff) {
        List<Staff> stafflist = staffdao.findAll();
        for (Staff other : stafflist) {
            if (other.getUsername().equals(staff.getUsername()) && other.getPassword().equals(staff.getPassword())) {
              //  staff.setLoggedIn(true);
               // staffdao.save(staff);
                return StatusLogin.SUCCESS;
            }
        }
        return StatusLogin.FAILURE;
    }
	
//	@GetMapping("/staffhome")
//	public String staffHome(){
//		return (String) "Welcome to Staff Home Page";
//
//	}
	
	//Get all assigned bug details
	@GetMapping("/allAssignedBug/{staffId}")
	public List<Bugs> getBugs(@PathVariable("staffId") Long staffid){
		return this.staffservices.getBugs(staffid);
		
	}
	
	@GetMapping("/resolveBug/{bugId}")
	public String resolveBug(@PathVariable("bugId") Long bugid) throws MessagingException{
		
				
		return (String) staffservices.resolveBug(bugid);
		
	}
	
	
	//Send three ids current staffid, bugid and staffid
	@PutMapping("/forwardBug")
	public void forwardBug(@RequestBody ForwardBug forwordbug ){
		staffservices.forwardBug(forwordbug);
		//staffservices.forwardBug(Long.parseLong(bugid),Long.parseLong(staffid));
		
	}
	
	
	
	
	
	
	
}