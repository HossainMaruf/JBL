package com.example.jbl.model;

import jakarta.persistence.Id;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
// @Table(name = "ccsps")
public class Ccsp  {
   @Id 
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false)
   private String name;

   @ManyToOne(optional = false)
   @JoinColumn(name = "departmentCode")
   private Department department;

   @Column(nullable = false)
   private String totalDuration = "4Y";

   @Column(nullable = false)
   private String termDuration = "6M";

   @Column(nullable = false)
   private Integer terms;

   @Enumerated(EnumType.STRING)
   @Column(nullable = false)
   private TermType termType = TermType.SEMESTER;
   
   @Column(updatable = false)
   @CreationTimestamp
   private LocalDateTime createdAt;

   @UpdateTimestamp
   private LocalDateTime updatedAt;

   // Constructors
   public Ccsp() {}
   public Ccsp(String name, Department department, Integer terms) {
        this.name = name;
        this.department = department;
        this.terms = terms;
   }

   // Getters
   public Long getId() {
    return id;
   }

   public String getName() {
    return name;
   }

   public Department getDepartment() {
    return department;
   }

   public String getTotalDuration() {
    return totalDuration;
   }

   public String getTermDuration() {
    return termDuration;
   }

   public Integer getTerms() {
    return terms;
   }

   public TermType getTermType() {
    return termType;
   }

   public LocalDateTime getCreatedAt() {
    return createdAt;
   }

   public LocalDateTime getUpdatedAt() {
    return updatedAt;
   }
  // Setters
   public void setId(Long id) {
    this.id = id;
   }

   public void setName(String name) {
    this.name = name;
   }

   public void setDepartment(Department department) {
    this.department = department;
   }

   public void setTotalDuration(String totalDuration) {
    this.totalDuration = totalDuration;
   }

   public void setTermDuration(String termDuration) {
    this.termDuration = termDuration;
   }

   public void setTerms(Integer terms) {
    this.terms = terms;
   }

   public void setTermType(TermType termType) {
    this.termType = termType;
   }
}
