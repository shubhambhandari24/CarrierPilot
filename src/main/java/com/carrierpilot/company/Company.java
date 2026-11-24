package com.carrierpilot.company;

import com.carrierpilot.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name="company")
@Entity
public class Company {
	@ManyToOne
	@JoinColumn(name="userId", nullable = false)
	private User user;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="company_name", length=100)
	private String companyName;
	private String industry;
	private String website;
	private String location;
	@Column(name="description", length=500)
	private String description;
	public Long getId() {
		return id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getIndustry() {
		return industry;
	}
	public String getWebsite() {
		return website;
	}
	public String getLocation() {
		return location;
	}
	public String getDescription() {
		return description;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Company(long id, String companyName, String industry, String website, String location, String description) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.industry = industry;
		this.website = website;
		this.location = location;
		this.description = description;
	}
	public Company( String companyName, String industry, String website, String location, String description) {
		this.companyName = companyName;
		this.industry = industry;
		this.website = website;
		this.location = location;
		this.description = description;
	}
	public Company() {
	}
	

}
