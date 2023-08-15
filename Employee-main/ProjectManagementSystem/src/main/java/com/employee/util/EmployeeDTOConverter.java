package com.employee.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.employee.dto.EmployeeResponseDTO;
import com.employee.entity.Employee;

@Component
@Scope("singleton")
public class EmployeeDTOConverter {
	
	public static EmployeeResponseDTO convertToDTO(Employee employee) {
		return new EmployeeResponseDTO(employee.getEmployeeId(),employee.getEmployeeName(),employee.getEmployeeDesignation(),employee.getProjectId(),employee.getRating());
	}

}