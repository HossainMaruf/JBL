package com.example.jbl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;


// @Table(name = "courses")
@Entity
public class Course {
    @Id
    private String code;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Float credit;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CourseType type;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Constructor
    public Course() {}
    public Course(String code, String title, Float credit, CourseType type) {
        this.code = code;
        this.title = title;
        this.credit = credit;
        this.type = type;
    }

    // Getters
    public String getCode() { return code; }
    public String getTitle() { return title; }
    public Float getCredit() { return credit; }
    public CourseType getType() { return type; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    // Setters
    public void setCode(String code) { this.code = code; }
    public void setTitle(String title) { this.title = title; }
    public void setCredit(Float credit) { this.credit = credit; }
    public void setType(CourseType type) { this.type = type; }
}