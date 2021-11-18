package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerResultDto {
    private Long id;
    private Long testResult;
    private Long question;
    private Double score;
    private List<Long> answerVariants;

    public AnswerResult toAnswerResult() {
        AnswerResult answerResult = new AnswerResult();
        answerResult.setId(id);
        //TODO add code
        return answerResult;
    }

}

