package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TeamLeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	private int mId;
	
	public TeamLeader() {
		super();
	}


public TeamLeader(int tId, String firstName, String lastName, String email, String password, int mId) {
	super();
	this.tId = tId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.mId = mId;
}

public int gettId() {
	return tId;
}


public void settId(int tId) {
	this.tId = tId;
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


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public int getmId() {
	return mId;
}


public void setmId(int mId) {
	this.mId = mId;
}
	
	
@Override
public String toString() {
	return "TeamLeader [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
			+ password + ", mId=" + mId + "]";
}






}
