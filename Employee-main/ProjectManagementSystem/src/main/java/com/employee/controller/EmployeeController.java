package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeResponseDTO;
import com.employee.dto.ErrorDTO;
import com.employee.dto.MyDTO;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.employee.util.EmployeeDTOConverter;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@Autowired
	EmployeeDTOConverter dtoConverter;

	@PostMapping("/addemployee")
	public ResponseEntity<MyDTO> addEmployee(@RequestBody Employee employee) {
		try {
			Employee savedEmployee = empService.addEmployee(employee);
			EmployeeResponseDTO dto = EmployeeDTOConverter.convertToDTO(savedEmployee);
			return new ResponseEntity<MyDTO>(dto, HttpStatus.OK);
		} catch (Exception e) {
			ErrorDTO errorDTO = new ErrorDTO(e.getMessage());
			return new ResponseEntity<MyDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
		try {
			String deletedEmployee = empService.deleteEmployee(employeeId);
			String responseMsg = "deleted the employee selected";
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Contact concerned manager \n" + e;
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employeeDetails) throws Exception {
		return empService.updateEmployee(employeeDetails);
	}

	@GetMapping("/get/{employeeId}")
	public Employee getEmployeeById(@PathVariable long employeeId) throws Exception {
		return empService.getEmployeeById(employeeId);
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		try {
			List<Employee> allExtractedEmployees = empService.getAllEmployees();
			return allExtractedEmployees;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@PutMapping("/updateProject/{employeeId}")
	ResponseEntity<Employee> updateProject(@PathVariable long employeeId,@RequestBody Employee emp) throws Exception{
		Employee updatedEmp = empService.updateProject(employeeId, emp);
		return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
	}
	
	@GetMapping("/getByProject/{projectId}")
	ResponseEntity<Employee> getByProjectId(@PathVariable int projectId){
		Employee emp = empService.getByProjectId(projectId);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}

}