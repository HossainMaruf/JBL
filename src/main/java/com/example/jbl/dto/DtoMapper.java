package com.example.jbl.dto;

import com.example.jbl.model.Ccsp;
import com.example.jbl.model.Department;

public class DtoMapper {
    public static CcspDto getCcspDto(Ccsp ccsp) {
        return new CcspDto(ccsp.getCode(),
                           ccsp.getName(),
                           ccsp.getDepartment().getCode(),
                           ccsp.getDepartment().getName(),
                           ccsp.getDepartment().getAbbreviation(),
                           ccsp.getTotalDuration(),
                           ccsp.getTermDuration(),
                           ccsp.getTerms(),
                           ccsp.getTermType().name(),
                           ccsp.getCreatedAt(),
                           ccsp.getUpdatedAt());
    }

    public static DepartmentDto getDepartmentDto(Department department) {
        return new DepartmentDto(department.getCode(),
                                 department.getName(),
                                 department.getAbbreviation(),
                                 department.getCcsps(),
                                 department.getCreatedAt(),
                                 department.getUpdatedAt());
    }
}
