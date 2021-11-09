package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.question_dto;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDto {
    private Long id;
    private String text;
    private Double score;
    private Integer position;
    private Boolean allowedParticleAnswer;
    private Long testId;

    public Question toQuestion(){
        Question question = new Question();
        question.setId(id);
        question.setText(text);
        question.setScore(score);
        question.setPosition(position);
        question.setAllowedParticleAnswer(allowedParticleAnswer);
        //FIXME question.setTest()
        //test

        return question;
    }

    public static QuestionDto fromQuestion(Question question) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(question.getId());
        questionDto.setScore(question.getScore());
        questionDto.setText(question.getText());
        questionDto.setPosition(question.getPosition());
        questionDto.setAllowedParticleAnswer(question.getAllowedParticleAnswer());

        questionDto.setTestId(question.getTest().getId());

        return questionDto;
    }
}