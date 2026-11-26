package com.carrierpilot.job.dto;

public class JobRequestDTO {
	private String jobTitle;
	private String jobType;
	private String location;
	private String salary;
	private String description;
	private Long companyId;
	public JobRequestDTO(String jobTitle, String jobType, String location, String salary, String description,
			Long companyId) {
		super();
		this.jobTitle = jobTitle;
		this.jobType = jobType;
		this.location = location;
		this.salary = salary;
		this.description = description;
		this.companyId = companyId;
	}
	public JobRequestDTO() {
		// TODO Auto-generated constructor stub
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

}
