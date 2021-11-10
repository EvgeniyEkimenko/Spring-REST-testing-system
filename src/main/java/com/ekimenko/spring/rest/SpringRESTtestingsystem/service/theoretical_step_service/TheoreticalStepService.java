package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.theoretical_step_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.TheoreticalStep;

import java.util.List;

public interface TheoreticalStepService {

    List<TheoreticalStep> getAllTheoreticalSteps();

    TheoreticalStep addNewTheoreticalStep(TheoreticalStep theoreticalStep);

    TheoreticalStep updateTheoreticalStep(TheoreticalStep theoreticalStep);

    TheoreticalStep getTheoreticalStepById(Long id);

    void deleteTheoreticalStepById(Long id);

}
