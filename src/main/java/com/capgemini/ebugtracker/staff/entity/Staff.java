package com.capgemini.ebugtracker.staff.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Staff {

	private String Fname;
	private String Lname;
	@Id
	private Long id;
	private String username;
	private String password;
	
	
}
