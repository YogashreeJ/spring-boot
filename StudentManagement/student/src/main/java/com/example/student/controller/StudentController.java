package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.student.dto.StudentRequestDTO;
import com.example.student.dto.StudentResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;



import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // GET all students
    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }


    // GET student by id
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudent(@PathVariable int id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }


    // POST add student
    @PostMapping
    public ResponseEntity<String> addStudent(
            @Valid @RequestBody StudentRequestDTO dto) {
        service.addStudent(dto);
        return new ResponseEntity<>("Student added successfully", HttpStatus.CREATED);
    }


    // DELETE student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }

}