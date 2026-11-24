package com.carrierpilot.company.dto;

public class CompanyResponseDTO {
	private Long id;
	private String companyName;
	private String website;
	private String industry;
	private String location;
	private String description;
	public CompanyResponseDTO() {
		// TODO Auto-generated constructor stub
	}
	public CompanyResponseDTO(Long id, String companyName, String website, String industry, String location,
			String description) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.website = website;
		this.industry = industry;
		this.location = location;
		this.description = description;
	}
	public Long getId() {
		return id;
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
	public void setId(Long id) {
		this.id = id;
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
	public CompanyResponseDTO(String companyName, String website, String industry, String location,
			String description) {
		super();
		this.companyName = companyName;
		this.website = website;
		this.industry = industry;
		this.location = location;
		this.description = description;
	}
	

}
