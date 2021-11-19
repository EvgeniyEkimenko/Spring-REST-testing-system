package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;

import java.util.List;

public interface AnswerResultService {

    AnswerResult toAnswerResult(AnswerResultDto answerResultDto);

    AnswerResultDto setPoints(AnswerResultDto answerResultDto);

    AnswerResultDto fromAnswerResult(AnswerResult answerResult);

    List<AnswerResultDto> getAllAnswerResultDto();

    AnswerResultDto getAnswerResultDtoById(long id);

    List<AnswerResult> getAllAnswerResult();

    AnswerResult getAnswerResultById(long id);

    void addNewAnswerResult(AnswerResult result);

    void updateAnswerResult(AnswerResult result);

    void deleteById(long id);



}
