/**
 * 
 */
package com.capgemini.ebugtracker.admin.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.capgemini.ebugtracker.bugs.repositery.BugDao;
import com.capgemini.ebugtracker.bugs.servies.BugServices;
import com.capgemini.ebugtracker.staff.entity.Staff;


/**
 * @author v62
 *
 */
@Service
public abstract class BugSeviceAdmin implements BugServices {

	@Autowired
	private BugDao bugdao;
	//List<Bugs> list;
	@Override
	public List<Bugs> getBugs() {
		// TODO Auto-generated method stub
		return bugdao.findAll();
	}

	public void addBug(Bugs bugs,Staff staff) {
		// TODO Auto-generated method stub
		
		bugdao.save(bugs);
	}

	@Override
	public List<Bugs> getBugs(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
