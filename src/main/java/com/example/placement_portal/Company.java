 package com.example.placement_portal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Company name cannot be empty")
    private String name;

    private String industry;
    private double minimumCgpaRequired;

    // One company can hire multiple students
    @OneToMany(mappedBy = "company", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonManagedReference
    private List<Student> hiredStudents = new ArrayList<>();

    // Default Constructor
    public Company() {}

    // Constructor with parameters
    public Company(String name, String industry, double minimumCgpaRequired) {
        this.name = name;
        this.industry = industry;
        this.minimumCgpaRequired = minimumCgpaRequired;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }

    public double getMinimumCgpaRequired() { return minimumCgpaRequired; }
    public void setMinimumCgpaRequired(double minimumCgpaRequired) { this.minimumCgpaRequired = minimumCgpaRequired; }

    public List<Student> getHiredStudents() { return hiredStudents; }
    public void setHiredStudents(List<Student> hiredStudents) { this.hiredStudents = hiredStudents; }
}