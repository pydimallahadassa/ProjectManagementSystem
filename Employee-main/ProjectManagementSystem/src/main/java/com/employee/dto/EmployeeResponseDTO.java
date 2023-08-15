package com.employee.dto;

public class EmployeeResponseDTO implements MyDTO{
	
	private Long employeeId;
	private String employeeName;
	private String employeeDesignation;
	private int projectId;
	private float rating;
	public EmployeeResponseDTO(long employeeId, String employeeName, String employeeDesignation, int projectId,
			float rating) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
		this.projectId = projectId;
		this.rating = rating;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	

}