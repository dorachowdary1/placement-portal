package com.example.placement_portal;

public class StudentDTO {
    private Long id;
    private String name;
    private String branch;
    private double cgpa;
    private boolean isPlaced;
    private String companyName;

    // Constructors
    public StudentDTO() {}

    public StudentDTO(Long id, String name, String branch, double cgpa, boolean isPlaced, String companyName) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;
        this.isPlaced = isPlaced;
        this.companyName = companyName;
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

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
}