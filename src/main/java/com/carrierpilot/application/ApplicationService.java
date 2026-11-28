package com.carrierpilot.application;

import java.util.List;

import com.carrierpilot.application.dto.ApplicationRequestDTO;
import com.carrierpilot.application.dto.ApplicationResponseDTO;

public interface ApplicationService {
	public ApplicationResponseDTO createApplication(ApplicationRequestDTO request, String useremail);
	public List<ApplicationResponseDTO> getAllApplication(String userEmail);
	public ApplicationResponseDTO getApplicationById(Long id, String userEmail);
	public ApplicationResponseDTO updateApplication(Long id, ApplicationRequestDTO request, String userEmail);
	public void deleteApplication(Long id, String userEmail);

}
