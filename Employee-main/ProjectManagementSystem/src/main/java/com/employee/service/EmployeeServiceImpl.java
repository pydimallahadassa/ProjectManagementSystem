package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employee.entity.Employee;
import com.employee.entity.Project;
import com.employee.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository empRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public EmployeeServiceImpl(EmployeeRepository taskRepo) {
		this.empRepository = empRepository;
	}
	

	@Override
	public Employee addEmployee(Employee employee) throws Exception {
		Employee savedEmployee = empRepository.save(employee);
		if(savedEmployee !=null) {
			return savedEmployee;
		}
		else
		return null;
	}

	@Override
	public Employee getEmployeeById(long employeeId) throws Exception {
		// TODO Auto-generated method stub
		return empRepository.findById(employeeId).get();
	}

	@Override
	public String deleteEmployee(long employeeId) throws Exception {
		empRepository.deleteById(employeeId);
		return "Employee with id "+employeeId+"has deleted";
	}

	@Override
	public Employee updateEmployee(Employee employee) throws Exception {
		Employee updatedEmployee = empRepository.save(employee);
		return updatedEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> allEmployees = empRepository.findAll();
		return allEmployees;
	}


	@Override
	public Employee updateProject(long employeeId, Employee emp)throws Exception {
		Optional<Employee> e1 = empRepository.findById(employeeId);
		if(e1.isPresent()) {
			Employee updatedEmp = e1.get();
			updatedEmp.setProjectId(emp.getProjectId());
			return updatedEmp;
		} else {
			throw new Exception("Employee not found with id: "+ employeeId);
		}
	}
	
	@Override
	public Employee getByProjectId(int projectId) {
		Employee e1 = empRepository.findByProjectId(projectId);
		Project project = restTemplate.getForObject("http://localhost:8082/project/get/"+e1.getProjectId(), Project.class);
		e1.setProject(project);
		return e1;
	}
	
	

}