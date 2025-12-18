package com.example.jbl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
// @Table(name = "departments")
public class Department {
   @Id
   private String code;

   @Column
   private String name;

   @Column
   private String abbreviation;

   @OneToMany(mappedBy = "department")
   private List<Ccsp> ccsps = new ArrayList<Ccsp>();

   @CreationTimestamp
   private LocalDateTime createdAt;

   @UpdateTimestamp
   private LocalDateTime updatedAt;

   // Constructors
   public Department() {}
   public Department(String code, String name, String abbreviation) {
      this.code = code;
      this.name = name;
      this.abbreviation = abbreviation;
   }

   // Getters
   public String getCode() {
      return code;
   }

   public String getName() {
      return name;
   }

   public String getAbbreviation() {
      return abbreviation;
   }

   public LocalDateTime getCreatedAt() {
      return createdAt;
   }

   public LocalDateTime getUpdatedAt() {
      return updatedAt;
   }

   // Setters
   public void setCode(String code) {
      this.code = code;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setAbbreviation(String abbreviation) {
      this.abbreviation = abbreviation;
   }
}
