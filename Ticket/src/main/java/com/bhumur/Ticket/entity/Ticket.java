package com.bhumur.Ticket.entity;

import java.sql.Date;

import com.bhumur.Ticket.entity.enums.Category;
import com.bhumur.Ticket.entity.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	@Column(name="phonenumber")
	@Size(max = 10, min = 5)
	String phonenumber;
	@Column(name="category")
	@Enumerated(EnumType.STRING)
	Category category;
	@Column(name="issuedetails")
	String issuedetails;
	@Column(name="resolutiondetails")
	String resolutiondetails;
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	Status status;
	@Column(name="createdate")
	Date createdate;
	@Column(name="resolutiondate")
	Date resolutiondate;
	public Ticket(int id, String phonenumber, Category category, String issuedetails, String resolutiondetails,
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
	public Ticket() {}
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
