package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;

import java.util.List;

public interface AnswerVariantService {

    List<AnswerVariant> getAllAnswerVariants();

    AnswerVariant getAnswerVariantById(long id);

    void addNewAnswerVariant(AnswerVariant answerVariant);

    void updateAnswerVariant(AnswerVariant answerVariant);

    void deleteAnswerVariantById(long id);


}
