package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id);
    }

    public void addStudent(Student student) {
        repository.save(student);
    }

    public void deleteStudent(int id) {
        repository.deleteById(id);
    }
}
