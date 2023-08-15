package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.admin.entity.Admin;
import com.admin.entity.EmpProject;
import com.admin.entity.Employee;
import com.admin.entity.Project;
import com.admin.repository.IAdminRepository;

@Service
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	IAdminRepository adminRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public AdminServiceImpl(IAdminRepository adminRepo) {
		this.adminRepo = adminRepo;
	}
	
	@Override
	public Admin addAdmin(Admin admin) {
		Admin newAdmin = adminRepo.save(admin);
		return newAdmin;
	}

	@Override
	public EmpProject addEmployeeToProject(int employeeId, int projectId) {
		
		return null;
	}

	@Override
	public Project addProject(Project project) {
		return restTemplate.postForObject("http://localhost:8082/project/add",project, Project.class);
	}

	@Override
	public Employee addEmployee(Employee emp) {
		return restTemplate.postForObject("http://localhost:9090/employee/addemployee",emp, Employee.class);
	}

	@Override
	public Employee updateEmployee(long employeeId, Employee emp) {
		return restTemplate.patchForObject("http://localhost:9090/employee/update",emp, Employee.class);
	}

//	@Override
//	public List<Project> viewAllProjects() {
//		return (List<Project>) restTemplate.getForObject("http://localhost:8082/project/getAll", Project.class);
//	}

}
