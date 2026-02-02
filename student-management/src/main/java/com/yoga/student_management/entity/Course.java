package com.yoga.student_management.entity;

import jakarta.persistence.*;//jakarta.persistence.* provides JPA annotations used to map Java classes and relationships to database tables, and it is the standard API used by Hibernate in Spring Boot 3.

@Entity
public class Course {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
