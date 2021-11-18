package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerVariantDto {
    private Long id;
    private String text;
    private Boolean correct;
    private Long questionId;
    private Long answerResultId;

    public AnswerVariant toAnswerVariant() {
        AnswerVariant answerVariant = new AnswerVariant();
        //TODO add code
        return answerVariant;
    }

}