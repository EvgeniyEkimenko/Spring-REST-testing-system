package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.answer_repos.AnswerVariantRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerVariantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AnswerVariantImpl implements AnswerVariantService {

    private final AnswerVariantRepository answerVariantRepository;

    @Autowired
    public AnswerVariantImpl(AnswerVariantRepository answerVariantRepository) {
        this.answerVariantRepository = answerVariantRepository;
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
