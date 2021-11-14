package com.capgemini.ebugtracker.admin.service;

import com.capgemini.ebugtracker.staff.entity.Staff;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface AdminServices {
    public Staff addNewStaff(@RequestBody Staff staff);
    //public Staff getStaff(Staff staff);
   // public List<StaffStatus> getStaffList();
    public void assignBug(Long bugid,Long staffid);
}
