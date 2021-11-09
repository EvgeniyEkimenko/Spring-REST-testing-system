package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getAllLessons();

    Lesson addNewLesson(Lesson lesson);

    Lesson updateLesson(Lesson lesson);

    Lesson getLessonById(Long id);

    void deleteLessonById(Long id);

}
