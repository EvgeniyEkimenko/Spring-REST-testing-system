package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;

import java.util.List;

public interface AnswerResultService {

    List<AnswerResult> getAllAnwserResult();

    AnswerResult getAnswerResultById(long id);

    void addNewAnswerResult(AnswerResult result);

    void updateAnswerResult(AnswerResult result);

    void deleteById(long id);

}
