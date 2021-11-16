package com.capgemini.ebugtracker.admin.service;

import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.capgemini.ebugtracker.staff.controller.StaffController;
import com.capgemini.ebugtracker.staff.entity.Staff;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface AdminServices {
	public void addNewStaff(@RequestBody Staff staff);
    //public Staff getStaff(Staff staff);
   // public List<StaffStatus> getStaffList();
	public void sendMessage(Bugs bug);
    
    public void assignBug(Long bugid,Long staffid);
}