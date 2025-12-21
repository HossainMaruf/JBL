package com.example.jbl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


// @Table(name = "departments")
@Entity
public class Department {
   @Id
   private String code;

   @Column
   private String name;

   @Column
   private String abbreviation;

   @OneToMany(mappedBy = "department")
   private List<Ccsp> ccsps;

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
   public String getCode() { return code; }
   public String getName() { return name; }
   public String getAbbreviation() { return abbreviation; }
   public List<Ccsp> getCcsps() { return ccsps; }
   public LocalDateTime getCreatedAt() { return createdAt; }
   public LocalDateTime getUpdatedAt() { return updatedAt; }

   // Setters
   public void setCode(String code) { this.code = code; }
   public void setName(String name) { this.name = name; }
   public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }
}