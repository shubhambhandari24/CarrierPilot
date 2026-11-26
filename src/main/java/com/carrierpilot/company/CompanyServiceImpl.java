package com.carrierpilot.company;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.carrierpilot.company.dto.CompanyRequestDTO;
import com.carrierpilot.company.dto.CompanyResponseDTO;
import com.carrierpilot.user.User;
import com.carrierpilot.user.UserRepository;
@Service
public class CompanyServiceImpl implements CompanyService{
	private final UserRepository userRepository;
	private final CompanyRepository companyRepository;
	public CompanyServiceImpl(UserRepository userRepository, CompanyRepository companyRepository) {
		this.companyRepository=companyRepository;
		this.userRepository=userRepository;
	}
	public User getAuthenticatedUser(String email) {
		User user = userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("this Email is not found"));
		return user;
	}
	public CompanyResponseDTO mapToDto(Company company) {
		return new CompanyResponseDTO(company.getId(), company.getCompanyName(), company.getWebsite(), company.getIndustry(), company.getLocation(), company.getDescription());
	}
//	Create Company
	public CompanyResponseDTO createCompany(CompanyRequestDTO request, String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		if(companyRepository.existsByCompanyNameAndUser(userEmail, user)) {
			throw new RuntimeException("Company Name is "+request.getCompanyName()+" Already Exists in your account");
		}
		Company company = new Company(request.getCompanyName(), request.getIndustry(), request.getWebsite(), request.getLocation(), request.getDescription(), user);
		Company savedCompany = companyRepository.save(company);
		return mapToDto(savedCompany);
	
	}
//	Get All Companies
	public List<CompanyResponseDTO> getAllCompanies(String userEmail){
		User user = getAuthenticatedUser(userEmail);
		List<Company> allCompanies = companyRepository.findByUser(user);
		List<CompanyResponseDTO> responseList=new ArrayList<CompanyResponseDTO>();
		for(Company company:allCompanies) {
			CompanyResponseDTO dto = mapToDto(company);
			responseList.add(dto);
		}
		return responseList;
	}
//	Get Company by Particular id and name, what if we check only user 1 and user wants company 5 id and that id is accessed by user 2, then user 1 can accessed the user 2 data which is SPY so we must check both user and company Id.
	@Override
	public CompanyResponseDTO getCompanyById(Long id, String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		Company company = companyRepository.findByIdAndUser(id, user).orElseThrow(()-> new RuntimeException("company not fouond with Id: "+id));
		return mapToDto(company);
	}
//	updateCompany.
	@Override
	public CompanyResponseDTO updateCompany(Long id, CompanyRequestDTO request, String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		Company company = companyRepository.findByIdAndUser(id, user).orElseThrow(()->new RuntimeException("Comapny not found with Id: "+id));
		company.setCompanyName(request.getCompanyName());
		company.setDescription(request.getDescription());
		company.setIndustry(request.getIndustry());
		company.setLocation(request.getLocation());
		company.setWebsite(request.getWebsite());
		Company savedCompany = companyRepository.save(company);
		return mapToDto(savedCompany);
		
	}
//	DeleteCompany
	@Override
	public void deleteCompany(Long id, String userEmail) {
		User user = getAuthenticatedUser(userEmail);
		Company company = companyRepository.findByIdAndUser(id, user).orElseThrow(()->new RuntimeException("Company with this Id is not Present"+id));
		companyRepository.delete(company);
		
	}

	
}
