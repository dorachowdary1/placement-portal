package com.example.placement_portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PlacementService placementService;

    @PostMapping("/add")
    public Company addCompany(@Valid @RequestBody Company company) {
        return companyRepository.save(company);
    }

    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @PostMapping("/{companyId}/hire/{studentId}")
    public String hireStudent(@PathVariable Long companyId, @PathVariable Long studentId) {
        return placementService.hireStudent(companyId, studentId);
    }
}