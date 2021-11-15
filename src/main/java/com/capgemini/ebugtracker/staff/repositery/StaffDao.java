package com.capgemini.ebugtracker.staff.repositery;


import com.capgemini.ebugtracker.staff.entity.Staff;
import com.capgemini.ebugtracker.admin.entity.StaffStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffDao extends JpaRepository<Staff, Long> {

   // @Query("Select new com.capgemini.ebugtracker.admin.entity.StaffStatus(s.sataffid,s.fname,s,lanme,b.bugid,b.title) From Staff s JOIN s.bugs b")
    //public List<StaffStatus> getStaffList();

}
