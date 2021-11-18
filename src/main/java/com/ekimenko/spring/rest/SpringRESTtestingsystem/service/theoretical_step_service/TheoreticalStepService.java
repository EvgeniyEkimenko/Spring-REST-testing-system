package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.theoretical_step_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.TheoreticalStepDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.TheoreticalStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test;

import java.util.List;

public interface TheoreticalStepService {

    TheoreticalStepDto fromTheoreticalStep(TheoreticalStep theoreticalStep);

    List<TheoreticalStepDto> getAllTheoreticalStepsDto();

    TheoreticalStepDto getTheoreticalStepDtoById(long id);

    List<TheoreticalStep> getAllTheoreticalSteps();

    TheoreticalStep addNewTheoreticalStep(TheoreticalStep theoreticalStep);

    TheoreticalStep updateTheoreticalStep(TheoreticalStep theoreticalStep);

    TheoreticalStep getTheoreticalStepById(Long id);

    void deleteTheoreticalStepById(Long id);

}
