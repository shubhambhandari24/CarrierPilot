package com.carrierpilot.interview.dto;

import java.time.LocalDateTime;

public class InterviewRequestDTO {
	private String roundName;
	private LocalDateTime interviewDate;
	private String status;
	private String feedback;
	private String meetingLink;
	private String interviewType;
	public InterviewRequestDTO() {
		// TODO Auto-generated constructor stub
	}
	public InterviewRequestDTO(String roundName, LocalDateTime interviewDate, String status, String feedback,
			String meetingLink, String interviewType) {
		super();
		this.roundName = roundName;
		this.interviewDate = interviewDate;
		this.status = status;
		this.feedback = feedback;
		this.meetingLink = meetingLink;
		this.interviewType = interviewType;
	}
	public String getRoundName() {
		return roundName;
	}
	public LocalDateTime getInterviewDate() {
		return interviewDate;
	}
	public String getStatus() {
		return status;
	}
	public String getFeedback() {
		return feedback;
	}
	public String getMeetingLink() {
		return meetingLink;
	}
	public String getInterviewType() {
		return interviewType;
	}
	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}
	public void setInterviewDate(LocalDateTime interviewDate) {
		this.interviewDate = interviewDate;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public void setMeetingLink(String meetingLink) {
		this.meetingLink = meetingLink;
	}
	public void setInterviewType(String interviewType) {
		this.interviewType = interviewType;
	}
	

}
