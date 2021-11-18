package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.answer_repos.AnswerResultRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerResultService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AnswerResultServiceImpl implements AnswerResultService {

    private final AnswerResultRepository resultRepository;

    @Autowired
    public AnswerResultServiceImpl(AnswerResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }


    @Override
    public AnswerResultDto fromAnswerResult(AnswerResult answerResult) {
        AnswerResultDto result = new AnswerResultDto();
        result.setId(answerResult.getId());
        result.setTestResult(answerResult.getTestResult().getId());
        result.setQuestion(answerResult.getQuestion().getId());
        result.setScore(answerResult.getScore());
        result.setAnswerVariants(ServiceUtil.getIds(answerResult.getAnswerVariants()));
        return result;
    }


    @Override
    public List<AnswerResultDto> getAllAnswerResultDto() {
        List<AnswerResult> results = getAllAnswerResult();

        List<AnswerResultDto> answerResultListDto = new ArrayList<>();
        for (AnswerResult result : results) {
            answerResultListDto.add(fromAnswerResult(result));
        }

        return answerResultListDto;
    }

    @Override
    public AnswerResultDto getAnswerResultDtoById(long id) {
        return fromAnswerResult(getAnswerResultById(id));
    }


    @Override
    public List<AnswerResult> getAllAnswerResult() {
        List<AnswerResult> results = resultRepository.findAll();
        log.info("IN getAllAnswerResult - {} results found", results.size());
        return results;
    }

    @Override
    public AnswerResult getAnswerResultById(long id) {
        AnswerResult result = resultRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("IN getAnswerResultById - no AnswerResult found by id: {}", id);
            return null;
        }
        log.info("IN getAnswerResultById  - result: {} found by id: {}", result, id);

        return result;
    }

    @Override
    public void addNewAnswerResult(AnswerResult result) {
        resultRepository.save(result);
        //TODO add log info
    }

    @Override
    public void updateAnswerResult(AnswerResult result) {
        resultRepository.save(result);
        //TODO add log info
    }


    @Override
    public void deleteById(long id) {
        resultRepository.deleteById(id);
        log.info("IN deleteById - AnswerResult with id: {} successfully deleted", id);
    }
}
