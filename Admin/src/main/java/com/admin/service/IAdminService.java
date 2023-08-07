package com.admin.service;

import com.admin.entity.Employee;
import com.admin.entity.Project;

public interface IAdminService {
	
	Employee addEmployeeToProject(int empId, int projectId);

}
