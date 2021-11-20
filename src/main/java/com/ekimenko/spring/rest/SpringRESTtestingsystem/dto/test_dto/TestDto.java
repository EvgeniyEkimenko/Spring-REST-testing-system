package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestDto {
    private Long id;
    private String name;
    private Long requeredScore;
    private Long numberAttempt;
    private List<Long> questionsId;
    private List<Long> testResultId;
    private Long lessonStepId;

}