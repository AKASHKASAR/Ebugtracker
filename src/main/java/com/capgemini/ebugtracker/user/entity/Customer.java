package com.capgemini.ebugtracker.user.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;
	private String fname;
	private String lname;
	private String emailid;
	private String username;
//	@JsonIgnore
	private String password;
	@OneToMany(targetEntity = Bugs.class,cascade = CascadeType.ALL)
	@JoinColumn(name="Ticket",referencedColumnName = "userid")
	private List<Bugs> bugs;
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Bugs> getBugs() {
		return bugs;
	}
	public void setBugs(List<Bugs> bugs) {
		this.bugs = bugs;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
