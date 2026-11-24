package com.carrierpilot.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrierpilot.user.dto.AuthResponseDTO;
import com.carrierpilot.user.dto.LoginRequestDTO;
import com.carrierpilot.user.dto.RegisterRequestDTO;
import com.carrierpilot.user.dto.UserResponseDTO;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService=userService;
	}
	@PostMapping("/register")
	public ResponseEntity<UserResponseDTO> registerUser(@RequestBody RegisterRequestDTO request) {
		 UserResponseDTO savedUsers = userService.registerUser(request);
		return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
	}
	@PostMapping("/login")
	public ResponseEntity<AuthResponseDTO> loginUser(@RequestBody LoginRequestDTO request){
		AuthResponseDTO loginUser = userService.loginUser(request);
		return new ResponseEntity<AuthResponseDTO>(loginUser, HttpStatus.OK);
	}
	@GetMapping("/profile")
	public org.springframework.http.ResponseEntity<String> getProfile() {
	    return org.springframework.http.ResponseEntity.ok("🎉 JWT is working! You are authenticated!");
	}

}
