package com.employee.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	
	private int projectId;
	private String projectName;
	private int teamMembers;
	private String teamLead;
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate deadLine;

}
