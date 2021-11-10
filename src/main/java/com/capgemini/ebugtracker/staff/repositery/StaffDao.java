package com.capgemini.ebugtracker.staff.repositery;

import javax.persistence.Id;
import com.capgemini.ebugtracker.staff.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffDao extends JpaRepository<Staff, Long> {

}
