package com.leader.model;

import javax.persistence.Column;
import javax.persistence.Entity;



import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class TeamMember {

	@Id
	@GeneratedValue
	private int mId;
	private String firstName;
	private String lastName;
	private String email;
	
	@Column
	private int tId;
	public TeamMember() {
		super();

	}

public TeamMember(int mId, String firstName, String lastName, String email, int tId) {
	super();
	this.mId = mId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.tId = tId;
}

public int getmId() {
	return mId;
}
public void setmId(int mId) {
	this.mId = mId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int gettId() {
	return tId;
}
public void settId(int tId) {
	this.tId = tId;
}
@Override
public String toString() {
	return "TeamMember [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", tId=" + tId + "]";
}
	
	
}