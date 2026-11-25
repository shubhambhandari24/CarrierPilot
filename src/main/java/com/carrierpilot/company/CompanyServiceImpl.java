package com.carrierpilot.company;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.carrierpilot.company.dto.CompanyRequestDTO;
import com.carrierpilot.company.dto.CompanyResponseDTO;
import com.carrierpilot.user.User;
import com.carrierpilot.user.UserRepository;

public class CompanyServiceImpl implements CompanyService{
	private final CompanyRepository companyRepository;
	private final UserRepository userRepository;
	public CompanyServiceImpl(CompanyRepository companyRepository, UserRepository userRepository) {
		this.companyRepository=companyRepository;
		this.userRepository=userRepository;
	}
	public User getAuthenticationByUser(String email) {
		return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User Not found with email: "+email));
	}
	public CompanyResponseDTO mapToDto(Company company) {
		return new CompanyResponseDTO(company.getId(),company.getCompanyName(), company.getWebsite(),company.getIndustry(),company.getDescription(), null);
	}
	@Override
	public CompanyResponseDTO createCompany(CompanyRequestDTO request, String userEmail) {
			User user = getAuthenticationByUser(userEmail);
			List<Company>  = companyRepository.findByUser(user);
	}

}
