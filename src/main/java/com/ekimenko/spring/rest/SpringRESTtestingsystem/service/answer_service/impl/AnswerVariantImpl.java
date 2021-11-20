package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerVariantDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.answer_repos.AnswerVariantRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerResultService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerVariantService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AnswerVariantImpl implements AnswerVariantService {

    private final AnswerVariantRepository answerVariantRepository;
    private final QuestionService questionService;
    private final AnswerVariantService answerVariantService;
    private final AnswerResultService answerResultService;

    @Autowired
    public AnswerVariantImpl(AnswerVariantRepository answerVariantRepository
            ,@Lazy QuestionService questionService
            ,@Lazy AnswerVariantService answerVariantService
            ,@Lazy AnswerResultService answerResultService) {
        this.answerVariantRepository = answerVariantRepository;
        this.questionService = questionService;
        this.answerVariantService = answerVariantService;
        this.answerResultService = answerResultService;
    }

    @Override
    public AnswerVariant toAnswerVariant(AnswerVariantDto answerVariantDto) {
        AnswerVariant answerVariant = new AnswerVariant();
        answerVariant.setId(answerVariantDto.getId());
        answerVariant.setText(answerVariantDto.getText());
        answerVariant.setCorrect(answerVariantDto.getCorrect());
        answerVariant.setQuestion(questionService.getQuestionById(answerVariantDto.getId()));
        answerVariant.setAnswerResult(answerResultService.getAnswerResultById(answerVariantDto.getAnswerResultId()));
        return answerVariant;
    }

    @Override
    public AnswerVariantDto fromAnswerVariant(AnswerVariant answerVariant) {
        AnswerVariantDto answerVariantDto = new AnswerVariantDto();
        answerVariantDto.setId(answerVariant.getId());
        answerVariantDto.setText(answerVariant.getText());
        answerVariantDto.setCorrect(answerVariant.getCorrect());
        answerVariantDto.setQuestionId(answerVariant.getQuestion().getId());
        answerVariantDto.setAnswerResultId(answerVariant.getAnswerResult().getId());

        return answerVariantDto;
    }

    @Override
    public List<AnswerVariantDto> getAllAnswerVariantsDto() {
        List<AnswerVariant> results = getAllAnswerVariants();

        List<AnswerVariantDto> answerVariantDtoList = new ArrayList<>();
        for (AnswerVariant result : results) {
            answerVariantDtoList.add(fromAnswerVariant(result));
        }
        return answerVariantDtoList;
    }

    @Override
    public AnswerVariantDto getAnswerVariantDtoById(long id) {
        return fromAnswerVariant(getAnswerVariantById(id));
    }

    @Override
    public List<AnswerVariant> getAllAnswerVariants() {
        List<AnswerVariant> answerVariants = answerVariantRepository.findAll();
        log.info("IN getAllAnswerVariants - {} answerVariants found", answerVariants.size());
        return answerVariants;
    }

    @Override
    public AnswerVariant getAnswerVariantById(long id) {
        AnswerVariant answerVariant = answerVariantRepository.findById(id).orElse(null);

        if (answerVariant == null) {
            log.warn("IN getAnswerVariantById - no answerVariants found by id: {}", id);
            return null;
        }
        log.info("IN getAnswerVariantById  - answerVariant: {} found by id: {}", answerVariant, id);
        return answerVariant;
    }

    @Override
    public void addNewAnswerVariant(AnswerVariant answerVariant) {
        //TODO add log info
        answerVariantRepository.save(answerVariant);
    }

    @Override
    public void updateAnswerVariant(AnswerVariant answerVariant) {
        //TODO add log info
        answerVariantRepository.save(answerVariant);
    }


    @Override
    public void deleteAnswerVariantById(long id) {
        answerVariantRepository.deleteById(id);
        log.info("IN deleteAnswerVariantById - AnswerVariant with id: {} successfully deleted", id);
    }

}
