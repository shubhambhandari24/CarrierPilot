package com.carrierpilot.user.dto;

public class UserResponseDTO {
	private long userId;
	
	private String email;
	private String role;
	public long getUserId() {
		return userId;
	}
	public String getEmail() {
		return email;
	}
	public String getRole() {
		return role;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserResponseDTO() {
		// TODO Auto-generated constructor stub
	}
	public UserResponseDTO(long userId, String email, String role) {
		super();
		this.userId = userId;
		this.email = email;
		this.role = role;
	}
	public UserResponseDTO(String email, String role) {
		super();
		this.email = email;
		this.role = role;
	}
	

}
