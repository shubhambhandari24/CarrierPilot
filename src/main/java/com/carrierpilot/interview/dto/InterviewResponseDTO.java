package com.carrierpilot.interview.dto;

import java.time.LocalDateTime;

public class InterviewResponseDTO {
	private Long id;
	private Long applicationId;
	private String jobTitle;
	private String companyName;
	private String roundName;
	private LocalDateTime interviewDate;
	private String interviewType;
	private String meetingLink;
	private String status;
	private String feedback;
	public InterviewResponseDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public InterviewResponseDTO(Long id,Long applicationId, String jobTitle, String companyName, String roundName,
			LocalDateTime interviewDate, String interviewType, String meetingLink, String status, String feedback) {
		super();
		this.id=id;
		this.applicationId = applicationId;
		this.jobTitle = jobTitle;
		this.companyName = companyName;
		this.roundName = roundName;
		this.interviewDate=interviewDate;
		this.interviewType = interviewType;
		this.meetingLink = meetingLink;
		this.status = status;
		this.feedback = feedback;
	}
	
	public Long getId() {
		return id;
	}
	public Long getApplicationId() {
		return applicationId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getRoundName() {
		return roundName;
	}
	public String getInterviewType() {
		return interviewType;
	}
	public String getMeetingLink() {
		return meetingLink;
	}
	public String getStatus() {
		return status;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}
	public void setInterviewType(String interviewType) {
		this.interviewType = interviewType;
	}
	public void setMeetingLink(String meetingLink) {
		this.meetingLink = meetingLink;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public void setInterviewDate(LocalDateTime interviewDate) {
		this.interviewDate=interviewDate;
	}
	public LocalDateTime getInterviewDate() {
		return interviewDate;
	}
	

}
