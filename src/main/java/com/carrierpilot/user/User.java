package com.carrierpilot.user;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userId;
	@Column(name="email",nullable=false ,unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String role="USER";
	public User(long userId, String email, String password, String role) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public long getUserId() {
		return userId;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
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
	public User(String email, String password, String role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User() {
	}
	
	
	

}
