package com.capgemini.ebugtracker.bugs.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.ebugtracker.bugs.entity.*;

public interface BugDao extends JpaRepository<Bugs, Long> {

}
