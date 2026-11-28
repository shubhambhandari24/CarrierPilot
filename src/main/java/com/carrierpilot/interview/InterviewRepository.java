package com.carrierpilot.interview;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrierpilot.application.Application;
public interface InterviewRepository extends JpaRepository<Interview, Long>{
	List<Interview>findByApplication(Application application);
	Optional<Interview>findByIdAndApplication(Long id, Application app );

}
