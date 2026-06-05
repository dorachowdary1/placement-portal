package com.example.placement_portal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Student name cannot be empty")
    private String name;

    @NotBlank(message = "Branch cannot be empty")
    private String branch;

    @Min(value = 0, message = "CGPA cannot be less than 0.0")
    @Max(value = 10, message = "CGPA cannot be greater than 10.0")
    private double cgpa;

    // Tracker flag to prevent double-placement conflicts
    private boolean isPlaced = false;

    // Relational mapping back to the hiring company
    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonBackReference
    private Company company;

    // Default Constructor
    public Student() {}

    // Constructor with parameters
    public Student(String name, String branch, double cgpa) {
        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public double getCgpa() { return cgpa; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }

    public boolean isPlaced() { return isPlaced; }
    public void setPlaced(boolean placed) { this.isPlaced = placed; }

    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }
}