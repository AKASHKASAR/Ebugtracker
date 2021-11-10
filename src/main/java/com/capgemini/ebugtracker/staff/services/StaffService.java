package com.capgemini.ebugtracker.staff.services;

import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.ebugtracker.staff.entity.Staff;

public interface StaffService {
	public Staff addNewStaff(Staff staff);

}
