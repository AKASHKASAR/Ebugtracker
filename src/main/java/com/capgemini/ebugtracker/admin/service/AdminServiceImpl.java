package com.capgemini.ebugtracker.admin.service;

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

   
    private BugDao bugdao;

    
    private StaffDao staffdao;
    //List<Bugs> list;

    //Add new staff
    @Override
    public Staff addNewStaff(Staff staff) {
        // TODO Auto-generated method stub
        //save staff detail
        staffdao.save(staff);

        //send username and password to staff
        Mailsender ms=new Mailsender();
        ms.setReceiver_id(staff.getEmailid());
        ms.setUsername(staff.getUsername());
        ms.setPassword(staff.getPassword());
        ms.sendmail();

        return staff;
    }


 //assign bug to staff
	public void assignBug(Long bugid,Long staffid) {
		// TODO Auto-generated method stub
        Bugs bug=bugdao.getById(bugid);
        bug.setStaff(staffdao.getById(staffid));
        bug.setStatus(Status.INPROGRESS);
        bugdao.save(bug);

	}

//    @Override
//    public Staff getStaff(Staff staff) {
//        // TODO Auto-generated method stub
//        return this.staffdao.getById(staff.getStaffid());
//    }


}
