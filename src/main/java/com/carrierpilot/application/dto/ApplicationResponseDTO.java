package com.carrierpilot.application.dto;

import java.time.LocalDate;

public class ApplicationResponseDTO {
	private Long id;
	private Long jobId;
	private String jobtitle;
	private String companyName;
	private LocalDate appliedDate;
	private String status;
	private String notes;
	public ApplicationResponseDTO(Long id, Long jobId, String jobtitle, String companyName, LocalDate appliedDate,
			String status, String notes) {
		super();
		this.id = id;
		this.jobId = jobId;
		this.jobtitle = jobtitle;
		this.companyName = companyName;
		this.appliedDate = appliedDate;
		this.status = status;
		this.notes = notes;
	}

	public ApplicationResponseDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public Long getJobId() {
		return jobId;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public String getCompanyName() {
		return companyName;
	}

	public LocalDate getAppliedDate() {
		return appliedDate;
	}

	public String getStatus() {
		return status;
	}

	public String getNotes() {
		return notes;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setAppliedDate(LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
