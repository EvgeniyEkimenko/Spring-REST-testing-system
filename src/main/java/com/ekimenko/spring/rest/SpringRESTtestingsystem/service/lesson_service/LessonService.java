package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service;


import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.LessonDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import java.util.List;

public interface LessonService {

    LessonDto fromLesson(Lesson lesson);

    List<LessonDto> getAllLessonsDto();

    LessonDto getLessonDtoById(long id);

    List<Lesson> getAllLessons();

    Lesson addNewLesson(Lesson lesson);

    Lesson updateLesson(Lesson lesson);

    Lesson getLessonById(Long id);

    void deleteLessonById(Long id);

}
