package com.example.jbl.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.example.jbl.model.Ccsp;

public class DepartmentDto {
   private String code; 
   private String name;
   private String abbreviation;
   
   // Expose from the relation
   private List<Ccsp> ccsps;

   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;

   public DepartmentDto(String code, String name, String abbreviation, List<Ccsp> ccsps,
                        LocalDateTime createdAt, LocalDateTime updatedAt) 
   {
        this.code = code;
        this.name = name;
        this.abbreviation = abbreviation;
        ccsps = new ArrayList<>();
        for (Ccsp ccsp : ccsps) {
           Ccsp c = new Ccsp(
            ccsp.getCode(),
            ccsp.getName(),
            ccsp.getTotalDuration(),
            ccsp.getTermDuration(),
            ccsp.getTerms(),
            ccsp.getTermType()
           );
            ccsps.add(c);
        }
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
   }

   // Getters
   public String getCode() { return code; }
   public String getName() { return name; }
   public String getAbbreviation() { return abbreviation; }
   public List<Ccsp> getCcsps() { return ccsps; }
   public LocalDateTime getCreatedAt() { return createdAt; }
   public LocalDateTime getUpdatedAt() { return updatedAt; }
}