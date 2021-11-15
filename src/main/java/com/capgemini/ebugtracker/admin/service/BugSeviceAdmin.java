/**
 * 
 */
package com.capgemini.ebugtracker.admin.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ebugtracker.bugs.entity.Status;
import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.capgemini.ebugtracker.bugs.repositery.BugDao;
import com.capgemini.ebugtracker.bugs.servies.BugServices;
import com.capgemini.ebugtracker.staff.entity.Staff;


/**
 * @author v62
 *
 */
@Service
public class BugSeviceAdmin implements BugServices {

	@Autowired
	private BugDao bugdao;
	List<Bugs> list;
	@Override
	public List<Bugs> getPendingBugs() {
		// TODO Auto-generated method stub
		ArrayList<Bugs> buglist = new ArrayList<>();
		list= bugdao.findAll();
		for(Bugs bug:list){
			if(bug.getStatus().equals(Status.INPROGRESS)) {
				buglist.add(bug);
			}
			
		}
		
			return buglist;
	}



	@Override
	public List<Bugs> getBugs() {
		ArrayList<Bugs> buglist = new ArrayList<>();
		list= bugdao.findAll();
		for(Bugs bug:list){
			if(bug.getStatus().equals(com.capgemini.ebugtracker.bugs.entity.Status.COMPLETED)) {
				buglist.add(bug);
			}
			
		}
		
			return buglist;

	}

	@Override
	public void addBug(Bugs bugs) {

	}



	@Override
	public List<Bugs> getNewBugs() {
		// TODO Auto-generated method stub
		ArrayList<Bugs> buglist = new ArrayList<>();
		list= bugdao.findAll();
		for(Bugs bug:list){
			if(bug.getStatus().equals(Status.CREATED)) {
				buglist.add(bug);
			}
			
		}
		
			return buglist;
	}



	@Override
	public List<Bugs> getAllBugs() {
		// TODO Auto-generated method stub
		return null;
	}


}
