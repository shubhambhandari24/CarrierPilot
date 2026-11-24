package com.carrierpilot.user;

import com.carrierpilot.user.dto.AuthResponseDTO;
import com.carrierpilot.user.dto.LoginRequestDTO;
import com.carrierpilot.user.dto.RegisterRequestDTO;
import com.carrierpilot.user.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO registerUser(RegisterRequestDTO request);	
    AuthResponseDTO loginUser(LoginRequestDTO request);
	

}
