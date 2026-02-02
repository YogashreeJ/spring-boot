// Service layer contains business logic, manages transactions, interacts with repositories, maps DTOs to entities and ensures data consistency
package com.yoga.student_management.service;

import com.yoga.student_management.dto.*;
import com.yoga.student_management.entity.*;
import com.yoga.student_management.repository.*;
import org.springframework.stereotype.Service; // marks this class as a service bean
import org.springframework.transaction.annotation.Transactional;//Enables transaction management
import org.springframework.data.domain.*;//Used in pagination method

@Service
public class StudentService {
    // dependencies to talk with db.This service depends on repositories to talk to DB.
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public StudentService(StudentRepository studentRepo, CourseRepository courseRepo) { // constructor injection
        this.studentRepo = studentRepo; // Repositories are interfaces because Spring generates the implementation at runtime using JPA
        this.courseRepo = courseRepo;
    }

    @Transactional // Either:ALL DB operations succeed → commit or ANY exception → rollback
    public StudentResponse addStudent(StudentRequest dto) {

        Course course = courseRepo.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Student student = new Student(); // Create Student entity
        // Copy data from DTO → Entity
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(course);

        // Save student
        studentRepo.save(student);

        // rollback demo
        if ("fail".equalsIgnoreCase(dto.getName())) {
            throw new RuntimeException("Intentional failure");
        }

        return mapToDTO(student); // converts entity to dto
    }

    public Page<StudentResponse> getStudents(int page, int size) {
        // Create Pageable
        Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
        return studentRepo.findAll(pageable).map(this::mapToDTO); // fetch student entity and convert into dto
    }

    private StudentResponse mapToDTO(Student s) {
        StudentResponse dto = new StudentResponse();
        dto.setId(s.getId());
        dto.setName(s.getName());
        dto.setEmail(s.getEmail());
        dto.setCourseName(s.getCourse().getName());
        return dto;
    }
}
