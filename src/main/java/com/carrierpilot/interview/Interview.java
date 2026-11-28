package com.carrierpilot.interview;

import java.time.LocalDateTime;

import com.carrierpilot.application.Application;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="interviews")
public class Interview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="company_id", nullable = false)
	private Application application;
	@Column(nullable = false)
	private String roundName;
	@Column(nullable = false)
	private LocalDateTime interviewDate;
	private String interviewType;
	private String meetingLink;
	private String status;
	private String feedBack;
	public Long getId() {
		return id;
	}
	public Application getApplication() {
		return application;
	}
	public String getRoundName() {
		return roundName;
	}
	public LocalDateTime getInterviewDate() {
		return interviewDate;
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
	public String getFeedBack() {
		return feedBack;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}
	public void setInterviewDate(LocalDateTime interviewDate) {
		this.interviewDate = interviewDate;
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
	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}
	public Interview(Long id, Application application, String roundName, LocalDateTime interviewDate,
			String interviewType, String meetingLink, String status, String feedBack) {
		super();
		this.id = id;
		this.application = application;
		this.roundName = roundName;
		this.interviewDate = interviewDate;
		this.interviewType = interviewType;
		this.meetingLink = meetingLink;
		this.status = status;
		this.feedBack = feedBack;
	}
	
	public Interview(Application application, String roundName, LocalDateTime interviewDate, String interviewType,
			String meetingLink, String status, String feedBack) {
		super();
		this.application = application;
		this.roundName = roundName;
		this.interviewDate = interviewDate;
		this.interviewType = interviewType;
		this.meetingLink = meetingLink;
		this.status = status;
		this.feedBack = feedBack;
	}
	

}
