package com.carrierpilot.user.dto;

public class AuthResponseDTO {
	private String email;
	private String token;
	public AuthResponseDTO(String email, String token) {
		super();
		this.email = email;
		this.token = token;
	}
	public String getEmail() {
		return email;
	}
	public String getToken() {
		return token;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public AuthResponseDTO() {
	}

}
