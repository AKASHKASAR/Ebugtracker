package com.capgemini.ebugtracker.admin.service;
import java.util.UUID; 
import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.capgemini.ebugtracker.bugs.entity.Status;
import com.capgemini.ebugtracker.bugs.repositery.BugDao;
import com.capgemini.ebugtracker.mailsender.Mailsender;
import com.capgemini.ebugtracker.mailsender.RandomUsername;
import com.capgemini.ebugtracker.staff.controller.StaffController;
import com.capgemini.ebugtracker.staff.entity.Staff;
import com.capgemini.ebugtracker.staff.repositery.StaffDao;
import com.capgemini.ebugtracker.user.entity.Customer;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author v62
 *
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminServices {

   
    @Autowired
    private BugDao bugdao;

    @Autowired
    private StaffDao staffdao;
    //List<Bugs> list;

    @Autowired
	RandomUsername rs;
    
    //Add new staff
    @Override
    public void addNewStaff(Staff staff) {
        // TODO Auto-generated method stub
        //save staff detail+
    	String fname=staff.getFname();
    	String lname=staff.getLname();
//    	if(lname.isEmpty()) {
//    		lname="ebug";
//    	}
    	
    	
    	//generate username
    	staff.setUsername(rs.usename(staff.getFname(), staff.getLname()));
    	
       
        //Generate random password
        staff.setPassword(rs.password(fname, lname));
    	staffdao.save(staff);
    	System.out.println("Staff Saved");
        //staffdao.save(staff);

       // send username and password to staff
//        Mailsender ms=new Mailsender();
//        ms.setReceiver_id(staff.getEmailid());
//        ms.setUsername(staff.getUsername());
//        ms.setPassword(staff.getPassword());
//        ms.sendmail();

       
    }


 //assign bug to staff
	public void assignBug(Long bugid,Long staffid) {
		// TODO Auto-generated method stub
        Bugs bug=bugdao.getById(bugid);
        bug.setStaff(staffdao.getById(staffid));
       bug.setStatus(Status.INPROGRESS);
        bugdao.save(bug);

	}


public void sendMessage(Bugs bug) {
	Mailsender ms=new Mailsender();
   
       Customer c=bug.getUser();
       ms.setReceiver_id(c.getEmailid());
       ms.sendmail(bug.getBugid());
	
}

//   @Override
//   public Staff getStaff(Staff staff) {
//        // TODO Auto-generated method stub
//        return this.staffdao.getById(staff.getStaffid());
//   }

}
