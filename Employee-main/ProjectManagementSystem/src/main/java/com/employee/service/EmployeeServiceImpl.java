package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository empRepository;
	

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
	public Employee getEmployeeById(Long employeeId) throws Exception {
		// TODO Auto-generated method stub
		return empRepository.findById(employeeId).get();
	}

	@Override
	public String deleteEmployee(Long employeeId) throws Exception {
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
	
	

}