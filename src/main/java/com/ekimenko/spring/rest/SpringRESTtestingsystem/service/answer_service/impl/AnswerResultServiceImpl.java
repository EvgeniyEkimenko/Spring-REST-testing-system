package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.answer_repos.AnswerResultRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<AnswerResult> getAllAnwserResult() {
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
