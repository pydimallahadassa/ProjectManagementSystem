package com.admin.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
	
	private long projectId;
	private String projectName;
	private String teamLead;
	private LocalDateTime deadLine;
	//private Team team;

}
