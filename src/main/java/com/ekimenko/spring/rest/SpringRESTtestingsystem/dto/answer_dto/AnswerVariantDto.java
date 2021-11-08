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

    public AnswerVariant toAnswerVariant() {
        AnswerVariant answerVariant = new AnswerVariant();
        answerVariant.setId(id);
        answerVariant.setText(text);
        answerVariant.setCorrect(correct);


        //FIXME answerVariant.setQuestion();

        return answerVariant;
    }

    public static AnswerVariantDto fromAnswerVariant(AnswerVariant answerVariant) {
        AnswerVariantDto answerVariantDto = new AnswerVariantDto();
        answerVariantDto.setId(answerVariant.getId());
        answerVariantDto.setText(answerVariant.getText());
        answerVariantDto.setCorrect(answerVariant.getCorrect());

        answerVariantDto.setQuestionId(answerVariant.getQuestion().getId());

        return answerVariantDto;
    }
}