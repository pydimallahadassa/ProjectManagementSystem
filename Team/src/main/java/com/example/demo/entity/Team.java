package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Team {
	
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public int getTeamMembers() {
		return teamMembers;
	}
	public void setTeamMembers(int teamMembers) {
		this.teamMembers = teamMembers;
	}
	@Id
	@GeneratedValue
	
	private int teamId;
	//@NotEmpty(message = "Name may not be empty")
	private int teamMembers;
	private String teamLead;
	public String getTeamLead() {
		return teamLead;
	}
	public void setTeamLead(String teamLead) {
		this.teamLead = teamLead;
	}
}
