package com.bhumur.Ticket.dto;

import java.sql.Date;

import com.bhumur.Ticket.entity.enums.Category;
import com.bhumur.Ticket.entity.enums.Status;

public class TicketDTO {
	int id;
	String phonenumber;
	Category category;
	String issuedetails;
	String resolutiondetails;
	Status status;
	Date createdate;
	Date resolutiondate;
	public TicketDTO(int id, String phonenumber, Category category, String issuedetails, String resolutiondetails,
			Status status, Date createdate, Date resolutiondate) {
		this.id = id;
		this.phonenumber = phonenumber;
		this.category = category;
		this.issuedetails = issuedetails;
		this.resolutiondetails = resolutiondetails;
		this.status = status;
		this.createdate = createdate;
		this.resolutiondate = resolutiondate;
	}
	public TicketDTO() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getIssuedetails() {
		return issuedetails;
	}
	public void setIssuedetails(String issuedetails) {
		this.issuedetails = issuedetails;
	}
	public String getResolutiondetails() {
		return resolutiondetails;
	}
	public void setResolutiondetails(String resolutiondetails) {
		this.resolutiondetails = resolutiondetails;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getResolutiondate() {
		return resolutiondate;
	}
	public void setResolutiondate(Date resolutiondate) {
		this.resolutiondate = resolutiondate;
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", phonenumber=" + phonenumber + ", category=" + category + ", issuedetails="
				+ issuedetails + ", resolutiondetails=" + resolutiondetails + ", status=" + status + ", createdate="
				+ createdate + ", resolutiondate=" + resolutiondate + "]";
	}
	
}
