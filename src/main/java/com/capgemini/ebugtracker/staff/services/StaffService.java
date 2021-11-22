package com.capgemini.ebugtracker.staff.services;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.capgemini.ebugtracker.admin.service.AdminServices;
import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.capgemini.ebugtracker.bugs.entity.Status;
import com.capgemini.ebugtracker.bugs.repositery.BugDao;
import com.capgemini.ebugtracker.staff.entity.ForwardBug;
import com.capgemini.ebugtracker.staff.repositery.StaffDao;

@Service
public class StaffService {
	
	@Autowired
	private AdminServices adminServices;
	@Autowired
	public StaffDao staffdao;
	@Autowired
	public BugDao bugdao;
	@Autowired
    private JavaMailSender javaMailSender;
	
  List<Bugs> list;
	
	public List<Bugs> getBugs(Long staffid) {
		ArrayList<Bugs> buglist = new ArrayList<>();
		list= bugdao.findAll();
		for(Bugs bug:list){
			if(bug.getStaff().getStaffid().equals(staffid)){
				buglist.add(bug);
			}
			
		}
		
			return buglist;
	}
    
	
	//Forwared bug to another staff
	public void forwardBug(ForwardBug forwardbug) {
		
		Bugs bug=bugdao.getById(forwardbug.getBugid());
		bug.setStaff(null);
		adminServices.assignBug(forwardbug.getBugid(),forwardbug.getAssignee_staffid());
	      
		// list=bugdao.findById(forwardbug.getAssigner_staffid());
	}
	
	
	public String resolveBug(Long bugId) throws MessagingException {
		Bugs bug=bugdao.getById(bugId);
		bug.setStatus(Status.COMPLETED);
		bugdao.save(bug);
		MimeMessage mimemsg = javaMailSender.createMimeMessage();
        MimeMessageHelper msg=new MimeMessageHelper(mimemsg,true);
        msg.setFrom("vijaylaxmi.joshi8@gmail.com");
        msg.setTo(bug.getUser().getEmailid());

        msg.setSubject("E-Bug Tracker System");
        msg.setText("Hi");
        msg.setText("Your ticket has been resoved succesfully.Ticket details as follows:");
        msg.setText("Ticket Title"+bug.getTitle()+"\n Ticket Id"+bug.getBugid());
        javaMailSender.send(mimemsg);
		return "Bug resolved succesfully";
		
	}

	

}
