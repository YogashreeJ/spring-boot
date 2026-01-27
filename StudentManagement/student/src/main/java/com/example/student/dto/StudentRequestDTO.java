package com.example.student.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class StudentRequestDTO {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 1, message = "Age must be greater than 0")
    private int age;

    public StudentRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
