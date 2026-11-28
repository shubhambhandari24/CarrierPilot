package com.carrierpilot.application;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrierpilot.user.User;

public interface ApplicationRepository extends JpaRepository<Application, Long>{
	List<Application>findByUser(User user);
	Optional<Application>findByIdAndUser(Long jobId, User user);

}
