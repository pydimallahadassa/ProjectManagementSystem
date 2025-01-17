package com.leader.main.entity;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamLeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int teamLeadId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	private int mId;


}
