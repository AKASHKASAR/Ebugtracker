/**
 * 
 */
package com.capgemini.ebugtracker.bugs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.capgemini.ebugtracker.staff.entity.Staff;
import com.capgemini.ebugtracker.user.entity.Customer;



/**
 * @author v62
 *
 */
@Entity
public class Bugs {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bugid;
	public Long getBugid() {
		return bugid;
	}

	public void setBugid(Long bugid) {
		this.bugid = bugid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	private String title;
	private String type;
	private String discription;
	private Status status;
	private Priority priority;
	
	//private String susername="Not Assigned";
	@ManyToOne
	private Customer user;
	
	@ManyToOne
	private Staff staff;
	
	
	
	
}
