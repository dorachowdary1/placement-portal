package com.example.placement_portal;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Existing filter
    List<Student> findByCgpaGreaterThan(double score);

    // UPGRADE: Filter by both CGPA AND Branch for the interview logic
    List<Student> findByBranchAndCgpaGreaterThanEqual(String branch, double score);
}