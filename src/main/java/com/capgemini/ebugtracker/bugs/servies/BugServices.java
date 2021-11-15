/**
 * 
 */
package com.capgemini.ebugtracker.bugs.servies;
import java.util.List;

import com.capgemini.ebugtracker.bugs.entity.Bugs;


/**
 * @author v62
 *
 */

public interface BugServices {
	
	public List<Bugs> getBugs();
	public void addBug(Bugs bugs);
	public List<Bugs> getPendingBugs();
	public List<Bugs> getNewBugs();
	public List<Bugs> getAllBugs();

	
}
