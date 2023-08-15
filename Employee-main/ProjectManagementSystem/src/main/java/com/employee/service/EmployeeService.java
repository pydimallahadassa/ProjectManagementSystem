package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.entity.Employee;

@Service
public interface EmployeeService {
	
	public Employee addEmployee(Employee employee) throws Exception;
	public Employee getEmployeeById(long employeeId)throws Exception;
	public String deleteEmployee(long employeeId) throws Exception;
	public Employee updateEmployee(Employee employee) throws Exception;
	public List<Employee> getAllEmployees() throws Exception;
	public Employee updateProject(long employeeId,Employee emp) throws Exception;
	Employee getByProjectId(int projectId);

}