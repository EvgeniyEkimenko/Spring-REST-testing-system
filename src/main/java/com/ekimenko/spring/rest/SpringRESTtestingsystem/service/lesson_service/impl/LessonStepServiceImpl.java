package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.LessonStepDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.LessonStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.LessonStepRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonStepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LessonStepServiceImpl implements LessonStepService {

    private final LessonStepRepository lessonStepRepository;

    @Autowired
    public LessonStepServiceImpl(LessonStepRepository lessonStepRepository) {
        this.lessonStepRepository = lessonStepRepository;
    }

    @Override
    public LessonStepDto fromLessonStep(LessonStep lessonStep) {
        LessonStepDto lessonStepDto = new LessonStepDto();
        lessonStepDto.setId(lessonStep.getId());
        lessonStepDto.setPositionInLesson(lessonStep.getPositionInLesson());
        lessonStepDto.setComplete(lessonStep.isComplete());
        lessonStepDto.setTheoreticalStepId(lessonStep.getTheoreticalStep().getId());
        lessonStepDto.setLessonId(lessonStep.getLesson().getId());
        lessonStepDto.setTestId(lessonStep.getTest().getId());

        return lessonStepDto;
    }

    @Override
    public List<LessonStepDto> getAllLessonStepsDto() {
        List<LessonStep> results = getAllLessonSteps();

        List<LessonStepDto> lessonStepDtoList = new ArrayList<>();
        for (LessonStep result : results) {
            lessonStepDtoList.add(fromLessonStep(result));
        }
        return lessonStepDtoList;
    }

    @Override
    public LessonStepDto getLessonStepDtoById(long id) {
        return fromLessonStep(getLessonStepById(id));
    }

    @Override
    public List<LessonStep> getAllLessonSteps() {
        List<LessonStep> lessonSteps = lessonStepRepository.findAll();
        log.info("IN getAllLessonSteps - {} lessons found", lessonSteps.size());
        return lessonSteps;
    }

    @Override
    public void addNewLessonStep(LessonStep lessonStep) {
        //TODO add log info
        lessonStepRepository.save(lessonStep);
    }

    @Override
    public void updateLessonStep(LessonStep lessonStep) {
        //TODO add log info
        lessonStepRepository.save(lessonStep);
    }

    @Override
    public LessonStep getLessonStepById(Long id) {

        LessonStep lessonStep = lessonStepRepository.findById(id).orElse(null);
        if (lessonStep==null) {
            log.warn("IN getLessonStepById - no lessonStep found by id: {}", id);
            return null;
        }
        log.info("IN getLessonStepById  - lessonStep: {} found by id: {}", lessonStep, id);
        return lessonStep;
    }

    @Override
    public void deleteLessonStepById(Long id) {
        lessonStepRepository.deleteById(id);
    }
}
