package com.example.jbl.dto;

import java.util.List;
import com.example.jbl.model.Ccsp;
import com.example.jbl.model.Department;

public class DtoMapper {
    public static CcspDto toCcspDto(Ccsp ccsp) {
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

    public static DepartmentDto toDepartmentDto(Department department) {
        List<CcspSummaryDto> ccspSummaryDtos = department.getCcsps()
                .stream()
                .map(ccsp -> {
                    return new CcspSummaryDto(ccsp.getCode(), ccsp.getName(), ccsp.getTotalDuration(),
                            ccsp.getTermDuration(), ccsp.getTerms(), ccsp.getTermType().name());
                })
                .toList();
        return new DepartmentDto(department.getCode(),
                department.getName(),
                department.getAbbreviation(),
                ccspSummaryDtos,
                department.getCreatedAt(),
                department.getUpdatedAt());
    }
}
