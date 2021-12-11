package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.LessonDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.impl.LessonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class LessonRestControllerV1Test {

    @Mock
    private LessonServiceImpl lessonService;  //try to delete "Impl" to use interface instead implementation
    @InjectMocks
    private LessonRestControllerV1 underTestController;

    private final Lesson lesson = new Lesson();

    @BeforeEach
    void setUp() {
        lesson.setId(1L);
        lesson.setName("testName");
        lesson.setDescription("testDesc");
        lesson.setComplete(false);
        lesson.setCourse(null);
        lesson.setLessonSteps(null);
    }

    @Test
    void getLessonById() {
    }

    @Test
    void getAllLessons() {
        //given
        List<Lesson> lessonList = new ArrayList<>();
        lessonList.add(lesson);
        List<LessonDto> expectedLessonDtoList = new ArrayList<>();

        LessonDto expectedLessonDto = new LessonDto();
        expectedLessonDto.setId(1L);
        expectedLessonDto.setName("testName");
        expectedLessonDto.setComplete(false);
        expectedLessonDto.setCourseId(null);
        expectedLessonDto.setLessonStepsId(Collections.emptyList());
        expectedLessonDto.setDescription("testDesc");
        expectedLessonDtoList.add(expectedLessonDto);

        //when
        when(lessonService.getAllLessonsDto()).thenReturn(expectedLessonDtoList);


        //then


    }

    @Test
    void addNewLesson() {
    }

    @Test
    void updateLesson() {
    }

    @Test
    void deleteLessonByID() {
    }
}