package com.carrierpilot.user;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.carrierpilot.exception.EmailAlreadyExistsException;
import com.carrierpilot.security.JwtService;
import com.carrierpilot.user.dto.AuthResponseDTO;
import com.carrierpilot.user.dto.LoginRequestDTO;
import com.carrierpilot.user.dto.RegisterRequestDTO;
import com.carrierpilot.user.dto.UserResponseDTO;
@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	private final JwtService jwtService;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
		this.userRepository=userRepository;
		this.passwordEncoder=passwordEncoder;
		this.jwtService = jwtService;
	}
	
	@Override
	public UserResponseDTO registerUser(RegisterRequestDTO request) {
		if(userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new EmailAlreadyExistsException("User Email already registered");
		}
		User user = new User();		
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole("USER");
		 User savedUsers = userRepository.save(user);
		 return new UserResponseDTO(savedUsers.getUserId(),savedUsers.getEmail(),savedUsers.getRole());
		
	}
	@Override
	public AuthResponseDTO loginUser(LoginRequestDTO request) {
		User user = userRepository.findByEmail(request.getEmail()).orElseThrow(()-> new RuntimeException("Invaled Credentials")) ;
		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
			throw new RuntimeException("Invalid Credentials");
		}
		String token = jwtService.generateToken(user.getEmail());
		return new AuthResponseDTO(user.getEmail(), token);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= userRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("USer not Found: "+username));
		return org.springframework.security.core.userdetails.User
				.withUsername(user.getEmail())
				.password(user.getPassword())
				.roles(user.getRole())
				.build();
	}
	

}
