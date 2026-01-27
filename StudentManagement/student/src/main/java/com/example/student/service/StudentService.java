package com.example.student.service;


import com.example.student.model.Student;
import com.example.student.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.student.dto.StudentRequestDTO;
import com.example.student.dto.StudentResponseDTO;
import com.example.student.exception.StudentNotFoundException;


import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repository;
    private int generateId() {
        return repository.findAll().size() + 1;
    }


    public List<StudentResponseDTO> getAllStudents() {
        return repository.findAll()
                .stream()
                .map(student ->
                        new StudentResponseDTO(
                                student.getId(),
                                student.getName(),
                                student.getAge()
                        )
                )
                .toList();
    }


    public StudentResponseDTO getStudentById(int id) {
        Student student = repository.findById(id);

        if (student == null) {
            throw new StudentNotFoundException("Student with id " + id + " not found");
        }

        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getAge()
        );
    }


    public void addStudent(StudentRequestDTO dto) {
        Student student = new Student();

        student.setId(generateId());
        student.setName(dto.getName());
        student.setAge(dto.getAge());

        repository.save(student);
    }


    public void deleteStudent(int id) {
        Student student = repository.findById(id);

        if (student == null) {
            throw new StudentNotFoundException("Student with id " + id + " not found");
        }

        repository.deleteById(id);
    }

}
