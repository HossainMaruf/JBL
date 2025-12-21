package com.example.jbl.dto;

import java.time.LocalDateTime;

public class CcspDto {
   private Long code; 
   private String name;

   // Expose from the relation
   private String departmentCode;
   private String departmentName;
   private String departmentAbbreviation;

   private String totalDuration;
   private String termDuration;
   private Integer terms;
   private String termType;
   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;

   public CcspDto(Long code, String name, String departmentCode,
                String departmentName, String departmentAbbreviation,
                String totalDuration, String termDuration, Integer terms,
                String termType, LocalDateTime createdAt, LocalDateTime updatedAt)
    {
        this.code = code;
        this.name = name;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.departmentAbbreviation = departmentAbbreviation;
        this.totalDuration = totalDuration;
        this.termDuration = termDuration;
        this.terms = terms;
        this.termType = termType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters
   public Long getCode() { return code; }
   public String getName() { return name; }
   public String getDepartmentCode() { return departmentCode; }
   public String getDepartmentName() { return departmentName; }
   public String getDepartmentAbbreviation() { return departmentAbbreviation; }
   public String getTotalDuration() { return totalDuration; }
   public String getTermDuration() { return termDuration; }
   public Integer getTerms() { return terms; }
   public String getTermType() { return termType; }
   public LocalDateTime getCreatedAt() { return createdAt; }
   public LocalDateTime getUpdatedAt() { return updatedAt; }
}
