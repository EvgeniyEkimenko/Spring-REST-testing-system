package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.theoretical_step_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.TheoreticalStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.TheoreticalStepRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.theoretical_step_service.TheoreticalStepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TheoreticalStepServiceImpl implements TheoreticalStepService {

    private final TheoreticalStepRepository theoreticalStepRepository;

    @Autowired
    public TheoreticalStepServiceImpl(TheoreticalStepRepository theoreticalStepRepository) {
        this.theoreticalStepRepository = theoreticalStepRepository;
    }

    @Override
    public List<TheoreticalStep> getAllTheoreticalSteps() {
        List<TheoreticalStep> theoreticalSteps = theoreticalStepRepository.findAll();
        log.info("IN getAllTheoreticalSteps - {} theoreticalSteps found", theoreticalSteps.size());
        return theoreticalSteps;
    }

    @Override
    public TheoreticalStep addNewTheoreticalStep(TheoreticalStep theoreticalStep) {
        //TODO add log info
        return theoreticalStepRepository.save(theoreticalStep);

    }

    @Override
    public TheoreticalStep updateTheoreticalStep(TheoreticalStep theoreticalStep) {
        //TODO add log info
        return theoreticalStepRepository.save(theoreticalStep);
    }

    @Override
    public TheoreticalStep getTheoreticalStepById(Long id) {
        TheoreticalStep theoreticalStep = theoreticalStepRepository.findById(id).orElse(null);
        if (theoreticalStep == null) {
            log.warn("IN getTheoreticalStepById - no theoreticalSteps found by id: {}", id);
            return null;
        }
        log.info("IN getTheoreticalStepById  - theoreticalStep: {} found by id: {}", theoreticalStep, id);
        return theoreticalStep;
    }

    @Override
    public void deleteTheoreticalStepById(Long id) {
        theoreticalStepRepository.deleteById(id);
        log.info("IN deleteTheoreticalStepById - TheoreticalStep with id: {} successfully deleted", id);
    }
}