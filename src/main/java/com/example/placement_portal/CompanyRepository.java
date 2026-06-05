package com.example.placement_portal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    // This gives us default save(), findAll(), and findById() methods for companies instantly!
}