package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerResultDto {
    private Long id;
    private Double score;

    private Long testResultId;

    public AnswerResult toAnswerResult(){
        AnswerResult answerResult = new AnswerResult();
        answerResult.setId(id);
        answerResult.setScore(score);

        //FIXME answerResult.setTestResult();

        return answerResult;
    }

    public static AnswerResultDto fromAnswerResult(AnswerResult answerResult) {
        AnswerResultDto result = new AnswerResultDto();
        result.setId(answerResult.getId());
        result.setScore(answerResult.getScore());

        //result.setTestResultId(answerResult.getTestResult().getId());

        return result;
    }
}




/*@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerResultDto {
    private Long id;
    private Double score;

    public AnswerResult toAnswerResult(){
        AnswerResult answerResult = new AnswerResult();
        answerResult.setId(id);
        answerResult.setScore(score);

        return answerResult;
    }

    public static AnswerResultDto fromAnswerResult(AnswerResult answerResult) {
        AnswerResultDto result = new AnswerResultDto();
        result.setId(answerResult.getId());
        result.setScore(answerResult.getScore());

        return result;
    }
}*/
