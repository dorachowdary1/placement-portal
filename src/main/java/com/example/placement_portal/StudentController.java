package com.example.placement_portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PlacementService placementService;

    @PostMapping("/add")
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/all")
    public List<StudentDTO> getAllStudents() {
        return placementService.getAllStudents();
    }

    @GetMapping("/eligible")
    public List<StudentDTO> getEligibleStudents(@RequestParam String branch, @RequestParam double minCgpa) {
        return placementService.filterStudents(branch, minCgpa);
    }
}