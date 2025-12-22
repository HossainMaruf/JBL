package com.example.jbl.dto;

public class CourseDto {
   private String code; 
   private String title;
   private Float credit;
   private String type;
   private Integer offeredTerm;
   private Boolean isOptional;

   public CourseDto(String code, String title, Float credit, String type, Integer offeredTerm, Boolean isOptional) {
      this.code = code;
      this.title = title;
      this.credit = credit;
      this.type = type;
      this.offeredTerm = offeredTerm;
      this.isOptional = isOptional;
   }

   // Getters
   public String getCode() { return code; }
   public String getTitle() { return title; }
   public Float getCredit() { return credit; }
   public String getType() { return type; }
   public Integer getOfferedTerm() { return offeredTerm; }
   public Boolean getIsOptional() { return isOptional; }
}
