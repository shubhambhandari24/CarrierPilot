package com.carrierpilot.user.dto;

public class RegisterRequestDTO {
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RegisterRequestDTO() {
		// TODO Auto-generated constructor stub
	}
	public RegisterRequestDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

}
