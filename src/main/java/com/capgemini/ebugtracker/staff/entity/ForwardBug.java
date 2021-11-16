package com.capgemini.ebugtracker.staff.entity;

import org.springframework.stereotype.Component;

@Component
public class ForwardBug {
	Long bugid;
	Long assigner_staffid;
	Long assignee_staffid;
	public Long getBugid() {
		return bugid;
	}
	public void setBugid(Long bugid) {
		this.bugid = bugid;
	}
	public Long getAssigner_staffid() {
		return assigner_staffid;
	}
	public void setAssigner_staffid(Long assigner_staffid) {
		this.assigner_staffid = assigner_staffid;
	}
	public Long getAssignee_staffid() {
		return assignee_staffid;
	}
	public void setAssignee_staffid(Long assignee_staffid) {
		this.assignee_staffid = assignee_staffid;
	} 
	

}
