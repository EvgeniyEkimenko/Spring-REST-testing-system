package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.theoretical_step_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.TheoreticalStepDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.TheoreticalStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.TheoreticalStepRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonStepService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util.ServiceUtil;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.theoretical_step_service.TheoreticalStepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TheoreticalStepServiceImpl implements TheoreticalStepService {

    private final TheoreticalStepRepository theoreticalStepRepository;
    private final LessonStepService lessonStepService;

    @Autowired
    public TheoreticalStepServiceImpl(TheoreticalStepRepository theoreticalStepRepository
            , @Lazy LessonStepService lessonStepService) {
        this.theoreticalStepRepository = theoreticalStepRepository;
        this.lessonStepService = lessonStepService;
    }

    @Override
    public TheoreticalStep toTheoreticalStep(TheoreticalStepDto theoreticalStepDto) {
        TheoreticalStep theoreticalStep = new TheoreticalStep();
        theoreticalStep.setId(theoreticalStep.getId());
        theoreticalStep.setName(theoreticalStepDto.getName());
        theoreticalStep.setDescription(theoreticalStepDto.getDescription());
        theoreticalStep.setLessonStep(lessonStepService.getLessonStepById(theoreticalStepDto.getLessonStepId()));
        theoreticalStep.setUsefulText(theoreticalStepDto.getUsefulText());
        return theoreticalStep;
    }

    @Override
    public TheoreticalStepDto fromTheoreticalStep(TheoreticalStep theoreticalStep) {
        TheoreticalStepDto theoreticalStepDto = new TheoreticalStepDto();
        theoreticalStepDto.setId(theoreticalStep.getId());
        theoreticalStepDto.setName(theoreticalStep.getName());
        theoreticalStepDto.setDescription(theoreticalStep.getDescription());
        theoreticalStepDto.setUsefulText(theoreticalStep.getUsefulText());
        theoreticalStepDto.setLessonStepId(ServiceUtil.getId(theoreticalStep.getLessonStep()));

        return theoreticalStepDto;
    }

    @Override
    public List<TheoreticalStepDto> getAllTheoreticalStepsDto() {
        List<TheoreticalStep> results = getAllTheoreticalSteps();

        List<TheoreticalStepDto> theoreticalStepDtoList = new ArrayList<>();
        for (TheoreticalStep result : results) {
            theoreticalStepDtoList.add(fromTheoreticalStep(result));
        }
        return theoreticalStepDtoList;
    }

    @Override
    public TheoreticalStepDto getTheoreticalStepDtoById(long id) {
        return fromTheoreticalStep(getTheoreticalStepById(id));
    }

    @Override
    public List<TheoreticalStep> getAllTheoreticalSteps() {
        List<TheoreticalStep> theoreticalSteps = theoreticalStepRepository.findAll();
        log.info("IN getAllTheoreticalSteps - {} theoreticalSteps found", theoreticalSteps.size());
        return theoreticalSteps;
    }

    @Override
    public TheoreticalStepDto addNewTheoreticalStep(TheoreticalStep theoreticalStep) {
        TheoreticalStep theoreticalStepResult = theoreticalStepRepository.save(theoreticalStep);
        log.info("IN addNewTheoreticalStep - TheoreticalStep : {} successfully added", theoreticalStepResult);
        return fromTheoreticalStep(theoreticalStepResult);

    }

    @Override
    public TheoreticalStepDto updateTheoreticalStep(TheoreticalStep theoreticalStep) {
        TheoreticalStep theoreticalStepResult = theoreticalStepRepository.save(theoreticalStep);
        log.info("IN addNewTheoreticalStep - TheoreticalStep : {} successfully updated", theoreticalStepResult);
        return fromTheoreticalStep(theoreticalStepResult);
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
