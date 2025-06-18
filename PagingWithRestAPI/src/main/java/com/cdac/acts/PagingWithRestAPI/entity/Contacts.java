package com.cdac.acts.PagingWithRestAPI.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="contacts")
public class Contacts {
	
	
	@Id
	@Column(name="contactId")
	int contactId;
	@Column(name="firstname")
	String firstname;
	@Column(name="lastname")
	String lastname;
	@Column(name="email")
	String email;
	@Column(name="gender")
	String gender;
	public Contacts() {}
	public Contacts(int contactId, String firstname, String lastname, String email, String gender) {
		super();
		this.contactId = contactId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.gender = gender;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Contacts [contactId=" + contactId + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", gender=" + gender + "]";
	}
	
	
}
