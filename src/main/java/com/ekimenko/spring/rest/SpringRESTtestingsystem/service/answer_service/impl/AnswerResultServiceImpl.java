package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.answer_repos.AnswerResultRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerResultServiceImpl implements AnswerResultService {

    private final AnswerResultRepository resultRepository;

    @Autowired
    public AnswerResultServiceImpl(AnswerResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public List<AnswerResult> getAllAnwserResult() {
        List<AnswerResult> results = resultRepository.findAll();

        return results;
    }

    @Override
    public AnswerResult getAnswerResultById(long id) {
        AnswerResult result = resultRepository.getById(id);

        return result;
    }

    @Override
    public void addNewAnswerResult(AnswerResult result) {
        resultRepository.save(result);
    }

    @Override
    public void updateAnswerResult(AnswerResult result) {
        resultRepository.save(result);
    }


    @Override
    public void deleteById(long id) {
        resultRepository.deleteById(id);
    }
}
