package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.answer_repos.AnswerVariantRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerVariantImpl implements AnswerVariantService {

    private final AnswerVariantRepository answerVariantRepository;

    @Autowired
    public AnswerVariantImpl(AnswerVariantRepository answerVariantRepository) {
        this.answerVariantRepository = answerVariantRepository;
    }

    @Override
    public List<AnswerVariant> getAllAnswerVariants() {
        List<AnswerVariant> answerVariants = answerVariantRepository.findAll();
        //TODO add log info
        return answerVariants;
    }

    @Override
    public AnswerVariant getAnswerVariantById(long id) {
        AnswerVariant answerVariant = answerVariantRepository.findById(id).orElse(null);

        if (answerVariant == null) {
            //TODO add log info
            return null;
        }
        //TODO add log info
        return answerVariant;
    }

    @Override
    public void addNewAnswerVariant(AnswerVariant answerVariant) {

        answerVariantRepository.save(answerVariant);

    }

    @Override
    public void updateAnswerVariant(AnswerVariant answerVariant) {

        answerVariantRepository.save(answerVariant);

    }


    @Override
    public void deleteAnswerVariantById(long id) {
        answerVariantRepository.deleteById(id);
        //TODO add log info
    }
}
