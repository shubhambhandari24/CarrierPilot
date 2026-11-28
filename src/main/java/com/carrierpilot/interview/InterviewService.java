package com.carrierpilot.interview;

import java.util.List;

import com.carrierpilot.interview.dto.InterviewRequestDTO;
import com.carrierpilot.interview.dto.InterviewResponseDTO;

public interface InterviewService {
	public InterviewResponseDTO scheduleInterview(Long applicationId, InterviewRequestDTO request, String userEmail);
	public List<InterviewResponseDTO> getAllInterviews(Long applicationId,String userEmail);
	public InterviewResponseDTO getInterviewById(Long id, Long applicationId, String userEmail);
	public InterviewResponseDTO updateInterview(Long id, Long applicationId, InterviewRequestDTO request, String userEmail);
	public void deleteInterview(Long id, Long applicationId, String userEmail);
}
