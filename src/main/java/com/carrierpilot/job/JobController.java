package com.carrierpilot.job;

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

import com.carrierpilot.job.dto.JobRequestDTO;
import com.carrierpilot.job.dto.JobResponseDTO;

@RestController
@RequestMapping("/api/companies/{companyId}/jobs")
public class JobController {
	private final JobService jobService;
	public JobController(JobService jobService) {
		this.jobService=jobService;
	}
//	POST: api/companies/1{comp_Id}/jobs.
	@PostMapping
	public ResponseEntity<JobResponseDTO> createJob(@PathVariable Long companyId,@RequestBody JobRequestDTO request, Authentication authentication){
		request.setCompanyId(companyId);
		String userEmail = authentication.getName();
		JobResponseDTO jobCreated = jobService.createJob(request, userEmail);
		return new ResponseEntity<JobResponseDTO>(jobCreated, HttpStatus.CREATED);
	}
//	GET: api/companies/1{CompId}/jobs.
	@GetMapping
	public ResponseEntity<List<JobResponseDTO>> getAllJobs(@PathVariable Long companyId, Authentication authtentication){
		String userEmail = authtentication.getName();
		List<JobResponseDTO> allJobsByCompany = jobService.getAllJobsByCompany(companyId, userEmail);
		return ResponseEntity.ok(allJobsByCompany);
	}
	@GetMapping("/{jobId}")
	public ResponseEntity<JobResponseDTO> getJobById(@PathVariable Long jobId,@PathVariable Long companyId, Authentication authentication){
		String userEmail = authentication.getName();
		JobResponseDTO jobById = jobService.getJobById(jobId, companyId, userEmail);
		return ResponseEntity.ok(jobById);
	}
//	PUT: api/companies/1{comp_Id}/jobs/1{Job_Id}
	@PutMapping("/{jobId}")
	public ResponseEntity<JobResponseDTO> updateJobById(@PathVariable Long jobId,@PathVariable Long companyId,@RequestBody JobRequestDTO request, Authentication authentication){
		String userEmail = authentication.getName();
		JobResponseDTO updateJobByCompanyId = jobService.updateJobByCompanyId(jobId, companyId, request, userEmail);
		return ResponseEntity.ok(updateJobByCompanyId);
	}
//	DELETE: api/companies/1{comp_Id}/jobs/1{jobId}
	@DeleteMapping("/{jobId}")
	public ResponseEntity<String> deleteJobsById(@PathVariable Long jobId,@PathVariable Long companyId, Authentication authentication){
		String userEmail = authentication.getName();
		jobService.deleteJobByCompanyId(jobId, companyId, userEmail);
		return ResponseEntity.ok("Job was Deleted Successfully with the Id:"+jobId);
		
	}

}
