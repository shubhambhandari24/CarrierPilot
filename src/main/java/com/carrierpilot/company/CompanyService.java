package com.carrierpilot.company;

import java.util.List;

import com.carrierpilot.company.dto.CompanyRequestDTO;
import com.carrierpilot.company.dto.CompanyResponseDTO;
public interface CompanyService {
	public CompanyResponseDTO createCompany(CompanyRequestDTO request, String userEmail);
	public List<CompanyResponseDTO> getAllCompanies(String userEmail);
	public CompanyResponseDTO getCompanyById(Long id, String userEmail);
	public CompanyResponseDTO updateCompany(Long id, CompanyRequestDTO request, String userEmail);
	public void deleteCompany(Long id, String userEmail);

}
