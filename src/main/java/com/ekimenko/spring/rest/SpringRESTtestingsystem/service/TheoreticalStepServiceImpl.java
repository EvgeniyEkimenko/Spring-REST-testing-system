package com.ekimenko.spring.rest.SpringRESTtestingsystem.service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.TheoreticalStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.TheoreticalStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheoreticalStepServiceImpl implements TheoreticalStepService{

    private final TheoreticalStepRepository theoreticalStepRepository;

    @Autowired
    public TheoreticalStepServiceImpl(TheoreticalStepRepository theoreticalStepRepository) {
        this.theoreticalStepRepository = theoreticalStepRepository;
    }

    @Override
    public List<TheoreticalStep> getAllTheoreticalSteps() {
        List<TheoreticalStep> theoreticalSteps = theoreticalStepRepository.findAll();
        return theoreticalSteps;
    }

    @Override
    public TheoreticalStep addNewTheoreticalStep(TheoreticalStep theoreticalStep) {
        return theoreticalStepRepository.save(theoreticalStep);
    }

    @Override
    public TheoreticalStep updateTheoreticalStep(TheoreticalStep theoreticalStep) {
        return theoreticalStepRepository.save(theoreticalStep);
    }

    @Override
    public TheoreticalStep getTheoreticalStepById(Long id) {
        TheoreticalStep theoreticalStep = theoreticalStepRepository.findById(id).orElse(null);
        if (theoreticalStep == null) {
            //TODO add log info
            return null;
        }
        //TODO add log info
        return theoreticalStep;
    }

    @Override
    public void deleteTheoreticalStepById(Long id) {
        theoreticalStepRepository.deleteById(id);
    }
}
