package com.carrierpilot.company;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carrierpilot.user.User;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    // 1. Find all companies belonging to this specific user
    List<Company> findByUser(User user);

    // 2. Find a specific company by its ID and user
    Optional<Company> findByIdAndUser(Long id, User user);

    // 3. Check if a company with this companyName already exists for this user
    boolean existsByCompanyNameAndUser(String companyName, User user);
}