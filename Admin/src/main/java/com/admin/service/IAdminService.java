package com.admin.service;

import java.util.List;

import com.admin.entity.Admin;
import com.admin.entity.EmpProject;
import com.admin.entity.Employee;
import com.admin.entity.Project;

public interface IAdminService {
	
	Admin addAdmin(Admin admin);
	EmpProject addEmployeeToProject(int employeeId, int projectId);
	Project addProject(Project project);
	Employee addEmployee(Employee emp);
	Employee updateEmployee(long employeeId, Employee emp);
//	List<Project> viewAllProjects();

}
