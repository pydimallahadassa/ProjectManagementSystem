package com.admin.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.entity.Employee;
import com.admin.entity.Project;
import com.admin.service.AdminServiceImpl;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminServ;
	
    private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/addproject")
	ResponseEntity<Project> addProject(@RequestBody Project project) {
		logger.info("Sending request to add new project");
		Project newProject = adminServ.addProject(project);
		logger.info("Added new project");
		return new ResponseEntity<>(newProject, HttpStatus.CREATED);
	}
	
	@PostMapping("/addemployee")
	ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		logger.info("Sending request to add new employee");
		Employee newemp = adminServ.addEmployee(emp);
		logger.info("Added new employee");
		return new ResponseEntity<>(newemp, HttpStatus.CREATED);
	}
	
//	@GetMapping("/viewprojects")
//	ResponseEntity<List<Project>> viewAllProjects() {
//		logger.info("Sending request to add new employee");
//		List<Project> projects = adminServ.viewAllProjects();
//		logger.info("Added new employee");
//		return new ResponseEntity<>(projects, HttpStatus.CREATED);
//	}

}
