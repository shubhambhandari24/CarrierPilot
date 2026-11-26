package com.carrierpilot.company;

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

import com.carrierpilot.company.dto.CompanyRequestDTO;
import com.carrierpilot.company.dto.CompanyResponseDTO;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
	private final CompanyService companyService;
	public CompanyController(CompanyService companyService) {
		this.companyService=companyService;
	}

	@PostMapping
	public ResponseEntity<CompanyResponseDTO> createCompany(@RequestBody CompanyRequestDTO request, org.springframework.security.core.Authentication authentication){
		String userEmail = authentication.getName();
		CompanyResponseDTO company = companyService.createCompany(request, userEmail);
		return new ResponseEntity<CompanyResponseDTO>(company, HttpStatus.CREATED);
		
	}
	@GetMapping
	public ResponseEntity<List<CompanyResponseDTO>> getAllCompanies(org.springframework.security.core.Authentication authentication){
		String userEmail = authentication.getName();
		List<CompanyResponseDTO> allCompanies = companyService.getAllCompanies(userEmail);
		return  ResponseEntity.ok(allCompanies);
	}
	@GetMapping("/{id}")
	public ResponseEntity<CompanyResponseDTO> getCompanyById(@PathVariable Long id, Authentication authentication){
		String userEmail = authentication.getName();
		CompanyResponseDTO companyById = companyService.getCompanyById(id, userEmail);
		return ResponseEntity.ok(companyById);
	}
	@PutMapping("/{id}")
	public ResponseEntity<CompanyResponseDTO> updateCompanyById(@PathVariable Long id, @RequestBody CompanyRequestDTO request , Authentication authentication){
		String userName = authentication.getName();
		CompanyResponseDTO updateCompany = companyService.updateCompany(id, request, userName);
		return ResponseEntity.ok(updateCompany);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompanyById(@PathVariable Long id, Authentication authentication){
		String userEmail = authentication.getName();
		companyService.deleteCompany(id, userEmail);
		return ResponseEntity.ok("Company was deleted Successfully by Id: "+id);
	}

}
