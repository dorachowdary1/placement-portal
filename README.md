# Smart Student Placement Analytics Portal

A high-performance, enterprise-grade Spring Boot REST backend system designed to automate collegiate recruitment pipelines, student academic records, and corporate matching criteria.

## 🛠️ Tech Stack
* **Framework:** Spring Boot 3.x
* **Language:** Java 17+
* **Data Layer:** Spring Data JPA, Hibernate ORM
* **Architecture Patterns:** DTO (Data Transfer Object) Pattern, Service Layer Pattern
* **Database:** MySQL
* **Build Tool:** Maven

## 🏗️ Production-Grade Layered Architecture
The project implements a strict separation of concerns across enterprise layers:
1. **Domain Layer (`Student`, `Company`):** Models relational database schemas using Hibernate annotations, configuring a bi-directional `@OneToMany` map.
2. **Data Transfer Layer (`StudentDTO`):** Enforces data encapsulation best practices. Decouples internal database schemas from external REST API representations.
3. **Data Access Layer (`StudentRepository`, `CompanyRepository`):** Leverages Spring Data JPA derived query methods for dynamic filtering engine operations.
4. **Service Business Logic Layer (`PlacementService`):** Isolates all transactional matching computations, eligibility validations, and object mapping away from controllers.
5. **API Controller Layer (`StudentController`, `CompanyController`):** Exposes decoupled JSON REST endpoints for safe system consumption.

## ⚙️ Key Backend Features & Rules
* **Enterprise DTO Mapping:** Flattens response profiles dynamically to deliver fast, network-optimized JSON data transfer packages.
* **Dynamic Filter Engine:** Screens unplaced student records instantly based on targeted branch matches and cut-off CGPA calculations.
* **Double-Placement Prevention:** Integrated database tracker flag (`isPlaced`) ensures a student cannot be allocated to multiple corporations.
* **Eligibility Guardrails:** Rejects hiring transactions automatically via service layer boundary constraints if a candidate fails a company's academic bar.

## 📡 Core API Endpoints

### 👨‍🎓 Student Management
* `GET /api/students/all` - Retrieves all current student records mapped to network-optimized DTO profiles.
* `POST /api/students/add` - Inserts a new student record (Validates name, branch, and CGPA <= 10.0).
* `GET /api/students/eligible` - Triggers the filter engine using `branch` and `minCgpa` parameters.

### 🏢 Corporate & Placement Operations
* `GET /api/companies/all` - Retrieves all registered corporate recruiters and their hired rosters.
* `POST /api/companies/add` - Adds a company recruitment profile with minimum academic bars.
* `POST /api/companies/{companyId}/hire/{studentId}` - Executes the transactional service engine to process candidate tracking.
*