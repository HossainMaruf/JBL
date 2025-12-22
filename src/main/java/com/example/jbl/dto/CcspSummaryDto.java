package com.example.jbl.dto;

public class CcspSummaryDto {
    private Long code;
    private String name;
    private String totalDuration;
    private String termDuration;
    private Integer terms;
    private String termType;

    public CcspSummaryDto(Long code, String name, String totalDuration, String termDuration, Integer terms,
            String termType) {
        this.code = code;
        this.name = name;
        this.totalDuration = totalDuration;
        this.termDuration = termDuration;
        this.terms = terms;
        this.termType = termType;
    }

    // Getters
    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
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

    public String getTermType() {
        return termType;
    }
}
