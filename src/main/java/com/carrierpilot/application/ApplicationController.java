package com.carrierpilot.application;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrierpilot.application.dto.ApplicationRequestDTO;
import com.carrierpilot.application.dto.ApplicationResponseDTO;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
	private final ApplicationService applicationService;

	public ApplicationController(ApplicationService applicationService) {
		super();
		this.applicationService = applicationService;
	}
	@PostMapping
	public ResponseEntity<ApplicationResponseDTO> createApplication(@RequestBody ApplicationRequestDTO request, Authentication authentication){
		String userEmail = authentication.getName();
		ApplicationResponseDTO application = applicationService.createApplication(request, userEmail);
		return new ResponseEntity<ApplicationResponseDTO>(application, HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<ApplicationResponseDTO>> getAllApplication(Authentication authentication){
		String userEmail = authentication.getName();
		List<ApplicationResponseDTO> allApplication = applicationService.getAllApplication(userEmail);
		return ResponseEntity.ok(allApplication);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ApplicationResponseDTO> getApplicationById(@PathVariable Long id, Authentication authentication){
		String userEmail = authentication.getName();
		ApplicationResponseDTO applicationById = applicationService.getApplicationById(id, userEmail);
		return ResponseEntity.ok(applicationById);
	}
	@PutMapping("/{id}")
	public ResponseEntity<ApplicationResponseDTO> updateApplication(@PathVariable Long id,@RequestBody ApplicationRequestDTO request, Authentication authentication){
		String userEmail = authentication.getName();
		ApplicationResponseDTO updatedApplication = applicationService.updateApplication(id, request, userEmail);
		return ResponseEntity.ok(updatedApplication);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteApplication(@PathVariable Long id, Authentication authentication){
		String userEmail = authentication.getName();
		applicationService.deleteApplication(id, userEmail);
		return ResponseEntity.ok("Application was Deleted Successfully with the Id of: "+id);
	}
	

}
