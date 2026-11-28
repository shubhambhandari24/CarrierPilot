package com.carrierpilot.interview;

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

import com.carrierpilot.interview.dto.InterviewRequestDTO;
import com.carrierpilot.interview.dto.InterviewResponseDTO;

@RestController
@RequestMapping("/api/applications/{applicationId}/interviews")
public class InterviewController {
	private final InterviewService interviewService;

	public InterviewController(InterviewService interviewService) {
		super();
		this.interviewService = interviewService;
	}
	@PostMapping
	public ResponseEntity<InterviewResponseDTO> schudhuleInterview(@PathVariable Long applicationId,@RequestBody InterviewRequestDTO request,Authentication authentication){
		String userEmail = authentication.getName();
		InterviewResponseDTO scheduleInterview = interviewService.scheduleInterview(applicationId, request, userEmail);
		return new ResponseEntity<InterviewResponseDTO>(scheduleInterview,HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<InterviewResponseDTO>> getAllInterviews(@PathVariable Long applicationId, Authentication authentication){
		String userEmail = authentication.getName();
		List<InterviewResponseDTO> allInterviews = interviewService.getAllInterviews(applicationId, userEmail);
		return ResponseEntity.ok(allInterviews);
	}
	@GetMapping("/{id}")
	public ResponseEntity<InterviewResponseDTO> getInterviewById(@PathVariable Long applicationId,@PathVariable Long id, Authentication authentication){
		String userEmail = authentication.getName();
		InterviewResponseDTO interviewById = interviewService.getInterviewById(applicationId, id, userEmail);
		return ResponseEntity.ok(interviewById);
	}
	@PutMapping("/{id}")
	public ResponseEntity<InterviewResponseDTO> updateInterview(@PathVariable Long applicationId,@PathVariable Long id,@RequestBody InterviewRequestDTO request, Authentication authentication){
		String userEmail = authentication.getName();
		InterviewResponseDTO updateInterview = interviewService.updateInterview(applicationId, id, request, userEmail);
		return ResponseEntity.ok(updateInterview);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteInterview(@PathVariable Long applicationId,@PathVariable Long id, Authentication authentication){
		String userEmail = authentication.getName();
		interviewService.deleteInterview(id, applicationId, userEmail);
		return ResponseEntity.ok("Interview was deleted successfully with Id"+id);
	}

}
