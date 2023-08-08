package com.admin.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.admin.entity.Project;
import com.admin.service.AdminServiceImpl;


@RestController

public class AdminController {
	
	@Autowired
	AdminServiceImpl adminServ;
	
    private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/project")
	ResponseEntity<Project> addProject(@RequestBody Project project) {
		logger.info("Sending request to add new project");
		Project newProject = adminServ.addProject(project);
		logger.info("Added new project");
		return new ResponseEntity<>(newProject, HttpStatus.CREATED);
	}
	
	

}
