package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LessonStepDto {
    private Long id;
    private Integer positionInLesson;
    private Boolean complete;
    private Long theoreticalStepId;
    private Long testId;
    private Long lessonId;
}