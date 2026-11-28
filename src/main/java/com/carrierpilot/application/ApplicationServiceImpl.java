package com.carrierpilot.application;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.carrierpilot.application.dto.ApplicationRequestDTO;
import com.carrierpilot.application.dto.ApplicationResponseDTO;
import com.carrierpilot.job.Job;
import com.carrierpilot.job.JobRepository;
import com.carrierpilot.user.User;
import com.carrierpilot.user.UserRepository;
@Service
public class ApplicationServiceImpl implements ApplicationService{
	private final ApplicationRepository applicationRepository;
	private final JobRepository jobRepository;
	private final UserRepository userRepository;
	public ApplicationServiceImpl(ApplicationRepository applicationRepository, JobRepository jobRepository,
			UserRepository userRepository) {
		this.applicationRepository = applicationRepository;
		this.jobRepository = jobRepository;
		this.userRepository = userRepository;
	}
	public User getAuthenticatedUser(String userEmail) {
		return  userRepository.findByEmail(userEmail).orElseThrow(()-> new UsernameNotFoundException("User not found with the email"+userEmail));
	}
	public ApplicationResponseDTO mapToDto(Application application) {
		 return new ApplicationResponseDTO(application.getId(), application.getJob().getId(), application.getJob().getJobTitle(),application.getJob().getCompany().getCompanyName(),application.getAppliedDate(),application.getStatus().name(),application.getNotes());
	}
	@Override
	public ApplicationResponseDTO createApplication(ApplicationRequestDTO request, String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		Job job = jobRepository.findById(request.getJobId()).orElseThrow(()-> new RuntimeException("Job not found with this App id: "+request.getJobId()));
		ApplicationStatus status = ApplicationStatus.valueOf(request.getStatus().toUpperCase());
		Application application = new Application(job, user, request.getAppliedDate(), status, request.getNotes());
		Application savedApp = applicationRepository.save(application);
		return mapToDto(savedApp);
	}
	@Override
	public List<ApplicationResponseDTO> getAllApplication(String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		List<Application> allApplication = applicationRepository.findByUser(user);
		List<ApplicationResponseDTO> responseList=new ArrayList<>();
		for(Application applicant:allApplication) {
			responseList.add(mapToDto(applicant));
		}
		return responseList;
	}
	@Override
	public ApplicationResponseDTO getApplicationById(Long id, String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		Application application = applicationRepository.findByIdAndUser(id, user).orElseThrow(()->new RuntimeException("Application not found with Id:"+id));
		return mapToDto(application);
	}
	@Override
	public ApplicationResponseDTO updateApplication(Long id, ApplicationRequestDTO request, String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		Application application = applicationRepository.findByIdAndUser(id, user).orElseThrow(()->new RuntimeException("Application Not Found with Id:"+id));
		if(request.getStatus()!=null) {
			application.setStatus(ApplicationStatus.valueOf(request.getStatus().toUpperCase()));
		}
		if(request.getNotes()!=null) {
			application.steNotes(request.getNotes());
		}
		Application saved = applicationRepository.save(application);
		return mapToDto(saved);
	}
	@Override
	public void deleteApplication(Long id, String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		Application application = applicationRepository.findByIdAndUser(id, user).orElseThrow(()-> new RuntimeException("Application Not Found with Id: "+id));
		applicationRepository.delete(application);
	}
	
	
	

}
