package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project {
	
	private int projectId;
	@NotEmpty(message = "Name may not be empty")
	private String projectName;
	private int teamMembers;
	private int teamLeadId;
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate deadLine;

}