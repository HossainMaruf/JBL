package com.example.jbl.model;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;

@Entity()
public class CcspCourse {
   @Id 
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long code;

   @ManyToOne(optional = false)
   @JoinColumn(name = "ccspCode")
   private Ccsp ccsp;

   @ManyToOne(optional = false)
   @JoinColumn(name = "courseCode")
   private Course course;

   @Column(nullable = false)
   private Integer offeredTerm = 8;

   @Column(nullable = false)
   private Boolean isOptional = false;

   @CreationTimestamp
   private LocalDateTime createdAt;

   @UpdateTimestamp
   private LocalDateTime updatedAt;

   // Constructors
   public CcspCourse() {}
   public CcspCourse(Ccsp ccsp, Course course) {
        this.ccsp = ccsp;
        this.course = course;
   }

   // Getters
   public Long getCode() { return code; }
   public Ccsp getCcsp() { return ccsp; }
   public Course getCourse() { return course; }
   public Integer getOfferedTerm() { return offeredTerm; }
   public Boolean getIsOptional() { return isOptional; }
   public LocalDateTime getCreatedAt() { return createdAt; }
   public LocalDateTime getUpdatedAt() { return updatedAt; }

   // Setters
   public void setCcsp(Ccsp ccsp) { this.ccsp = ccsp; }
   public void setCourse(Course course) { this.course = course; }
   public void setOfferedTerm(Integer offeredTerm) { this.offeredTerm = offeredTerm; }
   public void setIsOptional(Boolean isOptional) { this.isOptional = isOptional; }
}
