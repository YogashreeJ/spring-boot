package com.example.student.repo;

import com.example.student.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    public List<Student> findAll() {
        return students;
    }

    public Student findById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Student student) {
        students.add(student);
    }

    public void deleteById(int id) {
        students.removeIf(s -> s.getId() == id);
    }
}
