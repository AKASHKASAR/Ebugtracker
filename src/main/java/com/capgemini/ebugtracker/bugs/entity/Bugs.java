/**
 * 
 */
package com.capgemini.ebugtracker.bugs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;



/**
 * @author v62
 *
 */
@Entity
public class Bugs {
	
	
	@Id
	private Long id;
	private String title;
	private String type;
	private String discription;
	private Status status;
	private Priority priority;
	private String susername="Not Assigned";
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	

}
