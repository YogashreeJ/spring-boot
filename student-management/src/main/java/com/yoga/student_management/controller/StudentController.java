package com.yoga.student_management.controller;

import com.yoga.student_management.dto.*;
import com.yoga.student_management.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentResponse> addStudent(
            @Valid @RequestBody StudentRequest dto) {
        return ResponseEntity.ok(service.addStudent(dto));
    }

    @GetMapping
    public ResponseEntity<Page<StudentResponse>> getStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(service.getStudents(page, size));
    }
}
