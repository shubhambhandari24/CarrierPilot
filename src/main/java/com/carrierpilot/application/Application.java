package com.carrierpilot.application;

import java.time.LocalDate;

import com.carrierpilot.job.Job;
import com.carrierpilot.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="Application")
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="jobId", nullable = false)
	private Job job;
	@ManyToOne
	@JoinColumn(name="userId", nullable = false)
	private User user;
	@Column(nullable = false)
	private LocalDate appliedDate;
	@Enumerated(EnumType.STRING)
	private ApplicationStatus status;
	private String notes;
	public Application(Job job, User user, LocalDate appliedDate, ApplicationStatus status, String notes) {
		super();
		this.job = job;
		this.user = user;
		this.appliedDate = appliedDate;
		this.status = status;
		this.notes=notes;
	}
	public Application() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public Job getJob() {
		return job;
	}
	public User getUser() {
		return user;
	}
	public LocalDate getAppliedDate() {
		return appliedDate;
	}
	public ApplicationStatus getStatus() {
		return status;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setAppliedDate(LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}
	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}
	public void steNotes(String notes) {
		this.notes=notes;
	}
	public String getNotes() {
		return notes;
	}
	

}
