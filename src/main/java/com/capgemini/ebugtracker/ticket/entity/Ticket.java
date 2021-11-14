package com.capgemini.ebugtracker.ticket.entity;

import com.capgemini.ebugtracker.bugs.entity.Priority;
import com.capgemini.ebugtracker.bugs.entity.Status;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long ticketId;

    @Column(name = "bugId")
    private Long bugId;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private Status status;

    @Column(name = "priority")
    private Priority priority;

    @Column(name = "user")
    private Long userid;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getBugId() {
        return bugId;
    }

    public void setBugId(Long bugId) {
        this.bugId = bugId;
    }
}
