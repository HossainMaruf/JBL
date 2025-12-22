package com.example.jbl.dto;

import java.time.LocalDateTime;
import java.util.List;

public class DepartmentDto {
   private String code;
   private String name;
   private String abbreviation;

   // Expose from the relation
   private List<CcspSummaryDto> ccsps;

   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;

   public DepartmentDto(String code, String name, String abbreviation, List<CcspSummaryDto> ccsps,
         LocalDateTime createdAt, LocalDateTime updatedAt) {
      this.code = code;
      this.name = name;
      this.abbreviation = abbreviation;
      this.ccsps = ccsps;
      this.createdAt = createdAt;
      this.updatedAt = updatedAt;
   }

   // Getters
   public String getCode() { return code; }
   public String getName() { return name; }
   public String getAbbreviation() { return abbreviation; }
   public List<CcspSummaryDto> getCcsps() { return ccsps; }
   public LocalDateTime getCreatedAt() { return createdAt; }
   public LocalDateTime getUpdatedAt() { return updatedAt; }
}