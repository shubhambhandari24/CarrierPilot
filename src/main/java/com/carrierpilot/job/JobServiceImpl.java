package com.carrierpilot.job;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.carrierpilot.company.Company;
import com.carrierpilot.company.CompanyRepository;
import com.carrierpilot.job.dto.JobRequestDTO;
import com.carrierpilot.job.dto.JobResponseDTO;
import com.carrierpilot.user.User;
import com.carrierpilot.user.UserRepository;
@Service
public class JobServiceImpl implements JobService{
	private final UserRepository userRepository;
	private final CompanyRepository companyRepository;
	private final JobRepository jobRepository;
	public JobServiceImpl(UserRepository userRepository, CompanyRepository companyRepository, JobRepository jobRepository) {
		this.userRepository=userRepository;
		this.companyRepository=companyRepository;
		this.jobRepository=jobRepository;
	}
//	get authenticated User in DB-base.
	public  User getAuthenticatedUser(String userEmail) {
		return userRepository.findByEmail(userEmail).orElseThrow(()-> new UsernameNotFoundException("User Not Found With this "+userEmail+"Email address"));
	}
//	get the company and verify whearther this company belongs to others user or not becausee to support multi-tented feature 
	public Company getUnregisteredCompany(Long companyId, User user){
		return companyRepository.findByIdAndUser(companyId, user).orElseThrow(()-> new RuntimeException("Company not found with companyId: "+companyId));
	}
//	Create JobResponseDTo because directly we cannot share our entire entity it does have sensitive data's.
	public JobResponseDTO mapToDto(Job job) {
		return new JobResponseDTO(job.getId(), job.getJobTitle(), job.getJobType(), job.getLocation(), job.getDescription(),job.getSalary(), job.getCompany().getId(), job.getCompany().getCompanyName());
	}
//	Create Job.
	@Override
	public JobResponseDTO createJob(JobRequestDTO request, String userEmail) {
//		Check if user is authorized or not 
		User user = getAuthenticatedUser(userEmail);
//		Check wheather if this company belongs to others user or not.
		Company company = getUnregisteredCompany(request.getCompanyId(), user);
//		@ManyToOne oneCompany have many Jobs 
		Job job = new  Job(request.getJobTitle(),request.getJobType(),request.getLocation(),request.getSalary(),request.getDescription(), company);
		Job savedJob = jobRepository.save(job);
		return mapToDto(savedJob);
	}
	@Override
	public List<JobResponseDTO> getAllJobsByCompany(Long companyId, String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		Company company = getUnregisteredCompany(companyId, user);
		List<Job> jobList = jobRepository.findByCompany(company);
		List<JobResponseDTO> responseList= new ArrayList<>();
		for(Job job :jobList) {
				responseList.add(mapToDto(job));
		}
		return responseList;
	}
	@Override
	public JobResponseDTO getJobById(Long id, Long companyId, String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		Company company = getUnregisteredCompany(companyId, user);
		Job job = jobRepository.findByIdAndCompany(id, company).orElseThrow(()-> new RuntimeException("Job Not found with Id: "+id));
		return  mapToDto(job);
		
	}
	@Override
	public JobResponseDTO updateJobByCompanyId(Long id, Long companyId, JobRequestDTO request, String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		Company company = getUnregisteredCompany(companyId, user);
		Job job = jobRepository.findByIdAndCompany(id, company).orElseThrow(()-> new RuntimeException("Job not found with Id: "+id));
		job.setJobTitle(request.getJobTitle());
		job.setJobType(request.getJobType());
		job.setLocation(request.getLocation());
		job.setSalary(request.getSalary());
		job.setDescription(request.getDescription());
		Job savedJob = jobRepository.save(job);
		return mapToDto(savedJob);
	}
	@Override
	public void deleteJobByCompanyId(Long id, Long companyId, String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		Company company = getUnregisteredCompany(companyId, user);
		Job job = jobRepository.findByIdAndCompany(companyId, company).orElseThrow(()->new RuntimeException("Job Not found with Id: "+id));
		jobRepository.delete(job);
	}
	
}
