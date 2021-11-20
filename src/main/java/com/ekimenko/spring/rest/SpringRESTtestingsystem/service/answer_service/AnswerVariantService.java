package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerVariantDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;

import java.util.List;

public interface AnswerVariantService {

    AnswerVariant toAnswerVariant(AnswerVariantDto answerVariantDto);

    AnswerVariantDto fromAnswerVariant(AnswerVariant answerVariant);

    List<AnswerVariantDto> getAllAnswerVariantsDto();

    AnswerVariantDto getAnswerVariantDtoById(long id);

    List<AnswerVariant> getAllAnswerVariants();

    AnswerVariant getAnswerVariantById(long id);

    void addNewAnswerVariant(AnswerVariant answerVariant);

    void updateAnswerVariant(AnswerVariant answerVariant);

    void deleteAnswerVariantById(long id);


}
