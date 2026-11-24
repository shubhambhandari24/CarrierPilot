package com.carrierpilot.company;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrierpilot.user.User;

public interface CompanyRepository extends JpaRepository<Company, Long>{
//	find all Companies by single user. hahahaa
	List<Company>findByUser(User user);  
//	find by name and id of particular company.
	Optional<Company>findByIdAndUser(Long id, User user);
	boolean existsBynameAndCompany(String companyName, User user);
}
