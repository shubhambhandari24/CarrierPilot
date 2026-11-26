package com.carrierpilot.job.dto;

public class JobResponseDTO {
	private Long id;
	private String jobTitle;
	private String jobType;
	private String location;
	private String salary;
	private String description;
	private Long companyId;
	private String companyName;
	public JobResponseDTO() {
		// TODO Auto-generated constructor stub
	}
	public JobResponseDTO(Long id, String jobTitle, String jobType, String location, String salary, String description,
			Long companyId, String companyName) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.jobType = jobType;
		this.location = location;
		this.salary = salary;
		this.description = description;
		this.companyId = companyId;
		this.companyName = companyName;
	}
	public Long getId() {
		return id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public String getJobType() {
		return jobType;
	}
	public String getLocation() {
		return location;
	}
	public String getSalary() {
		return salary;
	}
	public String getDescription() {
		return description;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public JobResponseDTO(String jobTitle, String jobType, String location, String salary, String description,
			Long companyId, String companyName) {
		super();
		this.jobTitle = jobTitle;
		this.jobType = jobType;
		this.location = location;
		this.salary = salary;
		this.description = description;
		this.companyId = companyId;
		this.companyName = companyName;
	}
	
}
