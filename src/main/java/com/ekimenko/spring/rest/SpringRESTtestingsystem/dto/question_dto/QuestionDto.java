package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.question_dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDto {
    private Long id;
    private String text;
    private Double score;
    private Integer position;
    private Boolean allowedParticleAnswer;
    private Long testId;
    private List<Long> answerVariantsId;
    private List<Long> answerResultsId;


}