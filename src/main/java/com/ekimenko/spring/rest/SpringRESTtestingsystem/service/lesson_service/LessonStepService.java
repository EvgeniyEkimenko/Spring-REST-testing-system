package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.LessonStepDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.LessonStep;

import java.util.List;

public interface LessonStepService {

    LessonStep toLessonStep(LessonStepDto lessonStepDto);

    LessonStepDto fromLessonStep(LessonStep lessonStep);

    List<LessonStepDto> getAllLessonStepsDto();

    LessonStepDto getLessonStepDtoById(long id);

    List<LessonStep> getAllLessonSteps();

    LessonStepDto addNewLessonStep(LessonStep lessonStep);

    LessonStepDto updateLessonStep(LessonStep lessonStep);

    LessonStep getLessonStepById(Long id);

    void deleteLessonStepById(Long id);

}
