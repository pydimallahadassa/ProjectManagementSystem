package com.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.admin.entity.Employee;
import com.admin.entity.Project;
import com.admin.repository.IAdminRepository;

@Service
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	IAdminRepository adminRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Employee addEmployeeToProject(int empId, int projectId) {
		
		return null;
	}

	@Override
	public Project addProject(Project project) {
		Project p1 = restTemplate.getForObject("http://localhost:8082/project/add/"+project.getProjectId(), Project.class);
		return p1;
	}
	
	

}
