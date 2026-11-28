package com.carrierpilot.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.carrierpilot.application.Application;
import com.carrierpilot.application.ApplicationRepository;
import com.carrierpilot.interview.dto.InterviewRequestDTO;
import com.carrierpilot.interview.dto.InterviewResponseDTO;
import com.carrierpilot.user.User;
import com.carrierpilot.user.UserRepository;
@Service
public class InterviewServiceImpl implements InterviewService{
	private final UserRepository userRepository;
	private final ApplicationRepository applicationRepository;
	private final InterviewRepository interviewRepository;
	public InterviewServiceImpl(UserRepository userRepository, ApplicationRepository applicationRepository,
			InterviewRepository interviewRepository) {
		super();
		this.userRepository = userRepository;
		this.applicationRepository = applicationRepository;
		this.interviewRepository = interviewRepository;
	}
	public User getAuthenticatedUser(String userEmail){
		return userRepository.findByEmail(userEmail).orElseThrow(()-> new UsernameNotFoundException("User not found with this mail Id:"+userEmail));
	}
	public Application getApplicationExistsWithUser(Long applicationId, User user){
		return applicationRepository.findByIdAndUser(applicationId, user).orElseThrow(()->new RuntimeException("Application Not found with this Id:"+applicationId));
	}
	public InterviewResponseDTO mapToDto(Interview interview) {
		return new InterviewResponseDTO(interview.getId(),interview.getApplication().getId(),interview.getApplication().getJob().getJobTitle(), interview.getApplication().getJob().getCompany().getCompanyName(),interview.getRoundName(),interview.getInterviewType() ,interview.getInterviewDate(),interview.getMeetingLink(),interview.getStatus(),interview.getFeedBack());
	}
	@Override
	public InterviewResponseDTO scheduleInterview(Long applicationId, InterviewRequestDTO request, String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		Application application = getApplicationExistsWithUser(applicationId, user);
		Interview intterview = new Interview(application, request.getRoundName(),request.getInterviewDate(), request.getInterviewType(),request.getMeetingLink(),request.getStatus()!=null ? request.getStatus() : "SCHUDULED",request.getFeedback());
		Interview savedInterview = interviewRepository.save(intterview);
		return mapToDto(savedInterview);
	}
	@Override
	public List<InterviewResponseDTO> getAllInterviews(Long applicationId, String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		Application application = getApplicationExistsWithUser(applicationId, user);
		List<Interview> Applications = interviewRepository.findByApplication(application);
		List<InterviewResponseDTO> responseList= new ArrayList<>();
		for(Interview inter:Applications) {
			responseList.add(mapToDto(inter));
		}
		return responseList;
	}
	@Override
	public InterviewResponseDTO getInterviewById(Long id, Long applicationId, String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		Application application = getApplicationExistsWithUser(applicationId, user);
		Interview interview = interviewRepository.findByIdAndApplication(applicationId, application).orElseThrow(()->new RuntimeException("Interviwer Not Found with the ID:"+applicationId));
		return mapToDto(interview);
	}
	@Override
	public InterviewResponseDTO updateInterview(Long id, Long applicationId, InterviewRequestDTO request,
			String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		Application application = getApplicationExistsWithUser(applicationId, user);
		Interview interview = interviewRepository.findByIdAndApplication(applicationId, application).orElseThrow(()-> new RuntimeException("Interview not found with the id: "+applicationId));
		if(request.getRoundName()!=null) {
			interview.setRoundName(request.getRoundName());
		}
		if(request.getInterviewDate()!=null) {
			interview.setInterviewDate(request.getInterviewDate());
		}
		if(request.getInterviewType()!=null) {
			interview.setInterviewType(request.getInterviewType());
		}
		if(request.getMeetingLink()!=null) {
			interview.setMeetingLink(request.getMeetingLink());
		}
		if(request.getStatus()!=null) {
			interview.setStatus(request.getStatus());
		}
		if(request.getFeedback()!=null) {
			interview.setFeedBack(request.getFeedback());
		}
		Interview savedInterview = interviewRepository.save(interview);
		return mapToDto(savedInterview);
	}
	@Override
	public void deleteInterview(Long id, Long applicationId, String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		Application application = getApplicationExistsWithUser(applicationId, user);
		Interview interview = interviewRepository.findByIdAndApplication(applicationId, application).orElseThrow(()-> new RuntimeException("Interview not found with the Id:"+applicationId));
		interviewRepository.delete(interview);
	}

}
