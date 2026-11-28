package com.carrierpilot.application.dto;

import java.time.LocalDate;

public class ApplicationRequestDTO {
	private Long jobId;
	private LocalDate appliedDate;
	private String status;
	private String notes;
	public ApplicationRequestDTO() {
		// TODO Auto-generated constructor stub
	}
	public ApplicationRequestDTO(Long jobId, LocalDate appliedDate, String status, String notes) {
		super();
		this.jobId = jobId;
		this.appliedDate = appliedDate;
		this.status = status;
		this.notes = notes;
	}
	public Long getJobId() {
		return jobId;
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
	public void setJobId(Long jobId) {
		this.jobId = jobId;
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
