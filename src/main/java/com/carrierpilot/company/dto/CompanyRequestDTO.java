package com.carrierpilot.company.dto;

public class CompanyRequestDTO {
	private String companyName;
	private String website;
	private String industry;
	private String location;
	private String description;
	public CompanyRequestDTO() {
		// TODO Auto-generated constructor stub
	}
	public CompanyRequestDTO(String companyName, String website, String industry, String location, String description) {
		super();
		this.companyName = companyName;
		this.website = website;
		this.industry = industry;
		this.location = location;
		this.description = description;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getWebsite() {
		return website;
	}
	public String getIndustry() {
		return industry;
	}
	public String getLocation() {
		return location;
	}
	public String getDescription() {
		return description;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
