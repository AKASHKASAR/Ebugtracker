package com.capgemini.ebugtracker.admin.service;
import java.util.UUID; 
import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.capgemini.ebugtracker.bugs.entity.Status;
import com.capgemini.ebugtracker.bugs.repositery.BugDao;
import com.capgemini.ebugtracker.mailsender.Mailsender;
import com.capgemini.ebugtracker.staff.entity.Staff;
import com.capgemini.ebugtracker.staff.repositery.StaffDao;

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

    static String usingUUID() { 
        UUID randomUUID = UUID.randomUUID(); 
        return randomUUID.toString().replaceAll("-", ""); 
      } 
    
    //Add new staff
    @Override
    public void addNewStaff(Staff staff) {
        // TODO Auto-generated method stub
        //save staff detail+
    	String fname=staff.getFname();
    	String lname=staff.getLname();
    	if(lname.isEmpty()) {
    		lname="ebug";
    	}
    	
    	staff.setUsername(fname.substring(0,3)+lname.substring(0,3));
    	String randomString = usingUUID(); 
      //  System.out.println("Random string is: " + randomString); 
        System.out.println("Random string of 8 characters is: " + randomString.substring(0, 8)); 
        staff.setPassword(randomString.substring(0, 8));
    	staffdao.save(staff);
    	System.out.println("Staff Saved");
        //staffdao.save(staff);

        //send username and password to staff
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




//   @Override
//   public Staff getStaff(Staff staff) {
//        // TODO Auto-generated method stub
//        return this.staffdao.getById(staff.getStaffid());
//   }

}
