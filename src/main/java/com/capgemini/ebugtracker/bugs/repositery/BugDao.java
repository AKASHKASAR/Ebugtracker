package com.capgemini.ebugtracker.bugs.repositery;

import com.capgemini.ebugtracker.admin.entity.StaffStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.ebugtracker.bugs.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BugDao extends JpaRepository<Bugs, Long> {

}
