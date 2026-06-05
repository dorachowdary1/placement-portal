package com.example.placement_portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlacementService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CompanyRepository companyRepository;

    // Helper method to convert database Entity to safe DTO
    private StudentDTO convertToDTO(Student student) {
        String compName = (student.getCompany() != null) ? student.getCompany().getName() : "None";
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getBranch(),
                student.getCgpa(),
                student.isPlaced(),
                compName
        );
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<StudentDTO> filterStudents(String branch, double minCgpa) {
        return studentRepository.findByBranchAndCgpaGreaterThanEqual(branch, minCgpa)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public String hireStudent(Long companyId, Long studentId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (student.isPlaced()) {
            return "Error: Student '" + student.getName() + "' is already placed.";
        }

        if (student.getCgpa() < company.getMinimumCgpaRequired()) {
            return "Error: Student CGPA (" + student.getCgpa() + ") is lower than requirement (" + company.getMinimumCgpaRequired() + ").";
        }

        student.setPlaced(true);
        student.setCompany(company);
        studentRepository.save(student);

        return "Success: " + student.getName() + " has been successfully hired by " + company.getName() + "!";
    }
}

