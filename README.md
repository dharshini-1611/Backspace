Complaint Management System built using Spring Boot, Spring Data JPA (Hibernate ORM), and MySQL database.  

The project implements a one-to-many relationship between Users and Complaints, along with APIs for creating users, creating complaints, assigning users to multiple complaints, and retrieving complaint details with assigned user information.

The application is fully containerized using Docker, including Dockerfile and image/container setup for easy deployment and portability.

Tech Stack:
- Java 17
- Spring Boot
- Spring Data JPA (Hibernate ORM)
- MySQL
- Docker
- Maven

Features:
- Create User API
- Create Complaint API
- Assign User to Multiple Complaints API
- List Complaints with User Details API
- Dockerized deployment for local/container execution
