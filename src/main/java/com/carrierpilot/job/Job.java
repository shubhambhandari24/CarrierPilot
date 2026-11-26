package com.carrierpilot.job;

import com.carrierpilot.company.Company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="job")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String jobTitle;
	private String jobType;
	private String location;
	private String salary;
	private String description;
	@ManyToOne
	@JoinColumn(name="company_id", nullable = false)
	private Company company;
	public Job() {
		// TODO Auto-generated constructor stub
	}
	public Job(String jobTitle, String jobType, String location, String salary, String description, Company company) {
		super();
		this.jobTitle = jobTitle;
		this.jobType = jobType;
		this.location = location;
		this.salary = salary;
		this.description = description;
		this.company = company;
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
	public Company getCompany() {
		return company;
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
	public void setCompany(Company company) {
		this.company = company;
	}
	

}
