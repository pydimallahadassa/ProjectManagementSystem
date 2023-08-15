package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Team {
	
	@Id
	@GeneratedValue
	private int teamId;
	//@NotEmpty(message = "Name may not be empty")
	private int teamMembers;
	private int projectId;
	
	@Transient
	private Project project;
	
}
