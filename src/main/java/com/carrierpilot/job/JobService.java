package com.carrierpilot.job;

import java.util.List;

import com.carrierpilot.job.dto.JobRequestDTO;
import com.carrierpilot.job.dto.JobResponseDTO;

public interface JobService {
	public JobResponseDTO createJob(JobRequestDTO request, String userEmail);
	public List<JobResponseDTO>getAllJobsByCompany(Long companyId, String userEmail);
	public JobResponseDTO getJobById(Long id, Long companyId, String userEmail);
	public  JobResponseDTO updateJobByCompanyId(Long id, Long companyId, JobRequestDTO request, String userEmail);
	public void deleteJobByCompanyId(Long id, Long companyId, String userEmail);

}
