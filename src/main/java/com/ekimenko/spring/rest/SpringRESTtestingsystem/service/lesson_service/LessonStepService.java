package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.LessonStep;

import java.util.List;

public interface LessonStepService {

    List<LessonStep> getAllLessonSteps();

    LessonStep addNewLessonStep(LessonStep lessonStep);

    LessonStep updateLessonStep(LessonStep lessonStep);

    LessonStep getLessonStepById(Long id);

    void deleteLessonStepById(Long id);

}
