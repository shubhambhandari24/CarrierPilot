package com.carrierpilot.job;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrierpilot.company.Company;

public interface JobRepository extends JpaRepository<Job, Long>{
//	one company can have many jobs.
	List<Job>findByCompany(Company company);
//	get specific job by company id and job id.
	Optional<Job> findByIdAndCompany(Long id, Company company);

}
