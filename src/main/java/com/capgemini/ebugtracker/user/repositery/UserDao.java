package com.capgemini.ebugtracker.user.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.ebugtracker.user.entity.Customer;

public interface UserDao extends JpaRepository<Customer,Long> {

}
