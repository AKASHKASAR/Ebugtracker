package com.capgemini.ebugtracker.admin.entity;

import javax.persistence.Id;


public class StaffStatus {

    @Id
    private Long staffId;
    private Long fname;
    private Long lname;
    private Long bugId;
    private String bugTitle;
    /*
     private Integer inprogressCount;
       private Integer completed_Count;
        public StaffStatus(Long staffId, Long fname, Long lname, Long bugId, String bugTitle) {
            this.staffId = staffId;
            this.fname = fname;
            this.lname = lname;
            this.bugId = bugId;
            this.bugTitle = bugTitle;

        }
    */

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Long getFname() {
        return fname;
    }

    public void setFname(Long fname) {
        this.fname = fname;
    }

    public Long getLname() {
        return lname;
    }

    public void setLname(Long lname) {
        this.lname = lname;
    }

    public Long getBugId() {
        return bugId;
    }

    public void setBugId(Long bugId) {
        this.bugId = bugId;
    }

    public String getBugTitle() {
        return bugTitle;
    }

    public void setBugTitle(String bugTitle) {
        this.bugTitle = bugTitle;
    }

/*
    public Integer getInprogressCount() {
        return inprogressCount;
    }

    public void setInprogressCount(Integer inprogressCount) {
        this.inprogressCount = inprogressCount;
    }

    public Integer getCompleted_Count() {
        return completed_Count;
    }

    public void setCompleted_Count(Integer completed_Count) {
        this.completed_Count = completed_Count;
    }
}
*/
}