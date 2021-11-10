/**
 * 
 */
package com.capgemini.ebugtracker.bugs.servies;
import com.capgemini.ebugtracker.bugs.entity.*;
import java.util.List;


/**
 * @author v62
 *
 */
public interface BugServices {
	
	public List<Bugs> getBugs();
	public List<Bugs> getBugs(String username);
	public void addBug(Bugs bugs);
	
}
