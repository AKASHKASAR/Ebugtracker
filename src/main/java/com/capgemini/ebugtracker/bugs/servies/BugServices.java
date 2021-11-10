/**
 * 
 */
package com.capgemini.ebugtracker.bugs.servies;
import com.capgemini.ebugtracker.bugs.entity.*;
import java.util.List;

import org.springframework.stereotype.Service;


/**
 * @author v62
 *
 */
@Service
public interface BugServices {
	
	public List<Bugs> getBugs();
	public List<Bugs> getBugs(String username);
	public void addBug(Bugs bugs);
	
}
