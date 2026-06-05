package com.example.placement_portal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PlacementPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlacementPortalApplication.class, args);
	}

	// This code will run automatically right after the application starts up!
	@Bean
	public CommandLineRunner demoData(StudentRepository studentRepository, CompanyRepository companyRepository) {
		return args -> {
			// 1. Clear old data to prevent duplication crashes on restart
			studentRepository.deleteAll();
			companyRepository.deleteAll();

			// 2. Create and Save Sample Companies
			Company techCorp = new Company("Google", "Technology", 8.5);
			Company financeCorp = new Company("Goldman Sachs", "Finance", 7.5);
			companyRepository.save(techCorp);
			companyRepository.save(financeCorp);

			// 3. Create and Save Sample Students
			studentRepository.save(new Student("Rahul Chowdary", "Computer Science", 9.2));
			studentRepository.save(new Student("Anjali Sharma", "Information Technology", 8.1));
			studentRepository.save(new Student("Vikram Singh", "Mechanical", 7.8));

			System.out.println(">>>>> SUCCESS: Sample student and company data inserted into MySQL database! <<<<<");
		};
	}
}


