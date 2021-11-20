package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TheoreticalStepDto {
    private Long id;
    private String name;
    private String description;
    private String usefulText;
    private Long lessonStepId;


}