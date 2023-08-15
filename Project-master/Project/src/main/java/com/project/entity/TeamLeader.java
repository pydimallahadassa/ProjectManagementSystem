package com.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamLeader {
	
	private int teamLeadId;
	private String firstName;
	private String lastName;
	private String email;

}
